package status;

import exception.common.NotEnoughQuantityException;
import exception.common.QuantityUnderZeroException;
import item.EquipmentBox;
import item.enums.items.Equipments;
import lombok.Getter;
import status.enums.StatusType;

@Getter
public class UnitStatus {
    private BaseStatus baseStatus;
    private BaseStatus effectiveBaseStatus;
    private int level; //현재 레벨, 1레벨부터 시작
    private int exp; //레벨업 이후 획득한 경험치. 동급 몬스터 잡을 경우 1씩 오른다. 동급 몬스터는 캐릭터와 레벨 차이가 5이하여야 한다.
    private int statPoint; //stat을 추가할 수 있는 포인트. 레벨업 시 5 획득
    private int hp; //current health points
    private int maxHp;
    private int mp; //current mana points
    private int maxMp;
    private int sp;
    private int maxSp;
    private int weight;
    private int maxWeight;
    private static final int hpMultiple = 10; //1 vit = 10 maxHp;
    private static final int mpMultiple = 10; //1 arc = 10 maxMp;
    private static final int spMultiple = 10; //1 sta = 10 maxSp;
    private static final int weightMultiple = 10; //1 str = 10 maxWeight;
    private static final int maxExp = 100; //레벨업에 필요한 경험치

    public UnitStatus(BaseStatus baseStatus, int level) {
        this.baseStatus = baseStatus;
        this.level = level;
        this.exp = 0;
        this.statPoint = 0;
    }

    public UnitStatus copy() {
        return new UnitStatus(baseStatus.copy(), level);
    }

    public UnitStatus copyWithLevel(int level) {
        double scale = level / (double) this.level;
        return new UnitStatus(baseStatus.copyWithScale(scale), level);
    }

    public void updateEffectiveStatus(EquipmentBox equipmentBox) {
        BaseStatus effectiveBaseStatus = baseStatus.copy();
        for (Equipments equipment : equipmentBox.getAllEquipments()) {
            effectiveBaseStatus = effectiveBaseStatus.add(equipment.getStatus());
        }
        this.effectiveBaseStatus = effectiveBaseStatus;
        this.maxHp = effectiveBaseStatus.getBonusMaxHp() + effectiveBaseStatus.getVit() * hpMultiple;
        this.maxMp = effectiveBaseStatus.getBonusMaxMp() + effectiveBaseStatus.getArc() * mpMultiple;
        this.maxSp = effectiveBaseStatus.getBonusMaxSp() + effectiveBaseStatus.getSta() * spMultiple;
        this.maxWeight = effectiveBaseStatus.getBonusMaxWeight() + effectiveBaseStatus.getStr() * weightMultiple;
        // 현재 HP, MP, SP가 최대치를 초과하지 않도록 조정
        if (this.hp > this.maxHp) this.hp = this.maxHp;
        if (this.mp > this.maxMp) this.mp = this.maxMp;
        if (this.sp > this.maxSp) this.sp = this.maxSp;
    }


    public void changeHp(int hpChange) {
        this.hp += hpChange;
        if (this.hp > this.maxHp) this.hp = this.maxHp;
        if (this.hp < 0) this.hp = 0;
    }

    public void changeMp(int mpChange) {
        this.mp += mpChange;
        if (this.mp > this.maxMp) this.mp = this.maxMp;
        if (this.mp < 0) this.mp = 0;
    }

    public void changeSp(int spChange) {
        this.sp += spChange;
        if (this.sp > this.maxSp) this.sp = this.maxSp;
        if (this.sp < 0) this.sp = 0;
    }

    //return boolean for checking level up
    public boolean changeExp(int quantity) {
        if (this.exp + quantity < 0) throw new QuantityUnderZeroException("유닛의 경험치는 0미만으로 감소할 수 없습니다.");
        this.exp += quantity;
        if (this.exp >= maxExp) {
            this.level++;
            this.statPoint += 5;
            this.exp -= maxExp;
            return true;
        }
        return false;
    }

    public void useStatPoint(StatusType type, int quantity) {
        if (quantity > this.statPoint) throw new NotEnoughQuantityException("사용하려 하는 스텟포인트가 잔여 스테이터스 포인트보다 적습니다.");
        if (quantity <= 0) throw new QuantityUnderZeroException("사용하려 하는 스탯포인트는 1 이상이어야 합니다.");
        BaseStatus newBaseStatus = switch (type) {
            case VIT -> new BaseStatus(quantity, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            case ARC -> new BaseStatus(0, quantity, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            case STR -> new BaseStatus(0, 0, quantity, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            case STA -> new BaseStatus(0, 0, 0, quantity, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            case AGI -> new BaseStatus(0, 0, 0, 0, quantity, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            case WIS -> new BaseStatus(0, 0, 0, 0, 0, quantity, 0, 0, 0, 0, 0, 0, 0, 0);
            case LUK -> new BaseStatus(0, 0, 0, 0, 0, 0, quantity, 0, 0, 0, 0, 0, 0, 0);
            case CHA -> new BaseStatus(0, 0, 0, 0, 0, 0, 0, quantity, 0, 0, 0, 0, 0, 0);
        };
        this.baseStatus = this.baseStatus.add(newBaseStatus);
    }
}
