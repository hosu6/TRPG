package unit;

import item.Equipment;
import item.enums.EquipTypes;
import item.enums.Items;
import unit.enums.StatusType;
import unit.enums.UnitType;

import java.util.Collections;
import java.util.HashMap;

public class Unit {
    private final UnitType type;
    private final String name;
    private final HashMap<Items, Integer> inventory;
    private final HashMap<EquipTypes, Items> equipments;
    private Status baseStatus;
    private Status effectiveStatus;
    private int level; //현재 레벨, 1레벨부터 시작
    private int exp; //레벨업 이후 획득한 경험치. 동급 몬스터 잡을 경우 1씩 오른다. 동급 몬스터는 캐릭터와 레벨 차이가 5이하여야 한다.
    private static final int maxExp = 100; //레벨업에 필요한 경험치
    private int statPoint; //stat을 추가할 수 있는 포인트. 레벨업 시 5 획득
    private int skillPoint; //skill 레벨을 올릴 수 있는 포인트. 레벨업 시 3 획득
    private int hp; //current health points
    private int maxHp;
    private int mp; //current mana points
    private int maxMp;
    private int maxWeight;
    private static final int hpMultiple = 10; //1 vit = 10 maxHp;
    private static final int mpMultiple = 10; //1 arc = 10 maxMp;
    private static final int weightMultiple = 10; //1 str = 10 maxWeight;

    public Unit(UnitType type, String name, HashMap<Items, Integer> inventory, HashMap<EquipTypes, Items> equipments, Status baseStatus, int level) {
        this.type = type;
        this.name = name;
        this.inventory = inventory;
        this.equipments = equipments;
        this.baseStatus = baseStatus;
        this.level = level;
        this.exp = 0;
        this.statPoint = 0;
        this.skillPoint = 0;
        updateEffectiveStatus();
    }

    public Unit copy() {
        return new Unit(type, name, (HashMap<Items, Integer>) inventory.clone(), (HashMap<EquipTypes, Items>) equipments.clone(), baseStatus.copy(), level);
    }

    public HashMap<Items, Integer> getInventory() {
        return (HashMap<Items, Integer>) Collections.unmodifiableMap(inventory);
    }

    public void addInventoryItem(Items item, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("인벤토리에 저장하는 아이템 수량은 1이상이어야 합니다.");
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public void removeInventoryItem(Items item, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("인벤토리에 저장하는 아이템 수량은 1 이상이어야 합니다.");
        if (!inventory.containsKey(item)) throw new IllegalArgumentException("제거하려는 아이템이 인벤토리에 존재하지 않습니다.");
        int remaining = inventory.get(item) - quantity;
        if (remaining == 0) {
            inventory.remove(item);
        } else if (remaining > 0) {
            inventory.put(item, remaining);
        } else {
            throw new IllegalArgumentException("인벤토리의 " + item.getItem().getName() + " 수량이 " + quantity + "개보다 적습니다.");
        }
    }

    public HashMap<EquipTypes, Items> getEquipments() {
        return (HashMap<EquipTypes, Items>) Collections.unmodifiableMap(equipments);
    }

    public void addEquipment(Items item) {
        EquipTypes equipType = item.getItem().getItemType().getEquipType();
        if (equipType == EquipTypes.NOT_EQUITABLE) {
            throw new IllegalArgumentException(item.getItem().getName() + "은(는) 장착할 수 없는 아이템입니다.");
        }
        try{
            // 해당 슬롯에 이미 장비가 있다면 인벤토리로 되돌림
            if (equipments.containsKey(equipType)) {
                removeEquipment(equipType);
            }
            // 인벤토리 장비를 장착
            removeInventoryItem(item, 1);
            equipments.put(equipType, item);
            updateEffectiveStatus();
            System.out.println(item.getItem().getName() + "을(를) 장착했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeEquipment(EquipTypes type) {
        if (type == EquipTypes.NOT_EQUITABLE) {
            throw new IllegalArgumentException(EquipTypes.NOT_EQUITABLE+"장비는 착용/착용 해제가 불가합니다.");
        }
        if (!equipments.containsKey(type)){
            throw new IllegalArgumentException(type+"슬롯에 장착된 장비가 없습니다");
        }
        Items itemToRemove = equipments.get(type);
        try{
            addInventoryItem(itemToRemove, 1);
            equipments.remove(type);
            updateEffectiveStatus();
            System.out.println(itemToRemove.getItem().getName() + "을(를) 벗어 인벤토리로 이동했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(type+"장비를 벗는데 실패하였습니다.");
        }
    }

    public void removeAllEquipment() {
        try {
            equipments.keySet().forEach(this::removeEquipment);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("모든 장비를 벗는데 실패하였습니다.");
        }
    }

    public void updateEffectiveStatus() {
        Status effectiveStatus = baseStatus.copy();
        for (Items item : equipments.values()) {
            if(item.getItem() instanceof Equipment){
                Equipment equipment = (Equipment) item.getItem();
                effectiveStatus = effectiveStatus.add(equipment.getStatus());
            }
        }
        this.effectiveStatus = effectiveStatus;
        this.hp = effectiveStatus.getBonusMaxHp() + effectiveStatus.getVit() * hpMultiple;
        this.mp = effectiveStatus.getBonusMaxMp() + effectiveStatus.getArc() * mpMultiple;
        this.maxWeight = effectiveStatus.getBonusMaxWeight() + effectiveStatus.getStr() * weightMultiple;
    }
    public void gainExp(int exp) {
        this.exp += exp;
        if(this.exp>=maxExp){
            this.level++;
            this.statPoint += 5;
            this.skillPoint += 3;
            this.exp -= maxExp;
        }
    }
    public void useStatPoint(StatusType type, int quantity) {
        if(quantity>this.statPoint) throw new IllegalArgumentException("사용하려 하는 스텟포인트가 잔여 스테이터스 포인트보다 적습니다.");
        if(quantity<=0) throw new IllegalArgumentException("사용하려 하는 스탯포인트는 1 이상이어야 합니다.");
        Status newStatus = Status.EMPTY_STATUS;
        switch (type) {
            case VIT:
                newStatus = new Status(quantity, 0, 0,0, 0, 0, 0, 0, 0,0,0);
                break;
            case ARC:
                newStatus = new Status(0, quantity, 0,0, 0, 0, 0, 0, 0,0,0);
                break;
            case STR:
                newStatus = new Status(0, 0, quantity,0, 0, 0, 0, 0, 0,0,0);
                break;
            case STA:
                newStatus = new Status(0, 0, 0,quantity, 0, 0, 0, 0, 0,0,0);
                break;
            case AGI:
                newStatus = new Status(0, 0, 0,0, quantity, 0, 0, 0, 0,0,0);
                break;
            case WIS:
                newStatus = new Status(0, 0, 0,0, 0, quantity, 0, 0, 0,0,0);
                break;
            case LUK:
                newStatus = new Status(0, 0, 0,0, 0, 0, quantity, 0, 0,0,0);
                break;
            case CHA:
                newStatus = new Status(0, 0, 0,0, 0, 0, 0, quantity, 0,0,0);
                break;
        }
        this.baseStatus = this.baseStatus.add(newStatus);
    }

    public UnitType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Status getBaseStatus() {
        return baseStatus;
    }

    public Status getEffectiveStatus() {
        updateEffectiveStatus();
        return effectiveStatus;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getStatPoint() {
        return statPoint;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMp() {
        return mp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
