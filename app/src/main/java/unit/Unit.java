package unit;

import item.EquipmentBox;
import item.ItemBox;
import item.enums.EquipTypes;
import item.enums.items.Equipments;
import lombok.Getter;
import play.Play;
import skill.SkillBox;
import status.UnitStatus;
import status.enums.UnitMutableStatusType;
import unit.enums.UnitType;

@Getter
public class Unit {
    private final UnitType type;
    private final String name;
    private final ItemBox itemBox;
    private final EquipmentBox equipmentBox;
    private final SkillBox skillBox;
    private final UnitStatus unitStatus;

    public Unit(UnitType type, String name, ItemBox itemBox, EquipmentBox equipmentBox, SkillBox skillBox, UnitStatus unitStatus) {
        this.type = type;
        this.name = name;
        this.itemBox = itemBox;
        this.equipmentBox = equipmentBox;
        this.skillBox = skillBox;
        this.unitStatus = unitStatus;
        updateUnitStatus();
        healAllHpMpSp();
    }

    public void updateUnitStatus() {
        this.unitStatus.updateEffectiveStatus(equipmentBox);
    }

    public void healAllHpMpSp() {
        unitStatus.healAllHpMpSp();
    }

    public Unit copy() {
        return new Unit(type, name, itemBox.copy(), equipmentBox.copy(), skillBox.copy(), unitStatus.copy());
    }

    public Unit copyWithLevel(int level) {
        return new Unit(type, name, itemBox.copy(), equipmentBox.copy(), skillBox.copy(), unitStatus.copyWithLevel(level));
    }

    public void addEquipment(Equipments equipment) {
        EquipTypes equipType = equipment.getEquipType();
        // 해당 슬롯에 이미 장비가 있다면 인벤토리로 되돌림
        removeEquipment(equipType);
        if (equipType.equals(EquipTypes.TWO_HAND)) {
            removeEquipment(EquipTypes.MAIN_HAND);
            removeEquipment(EquipTypes.OFF_HAND);
        } else if (equipType.equals(EquipTypes.MAIN_HAND) || equipType.equals(EquipTypes.OFF_HAND)) {
            removeEquipment(EquipTypes.TWO_HAND);
        }
        equipmentBox.addEquipment(equipment);
        itemBox.removeInventoryItem(equipment, 1);
        updateUnitStatus();
        Play.println(equipment.getName() + "을(를) 장착했습니다.");
    }

    public void removeEquipment(EquipTypes type) {
        Equipments equipment = equipmentBox.get(type);
        equipmentBox.removeEquipment(type);
        itemBox.addInventoryItem(equipment, 1);
        updateUnitStatus();
        Play.println(equipment.getName() + "을(를) 벗어 인벤토리로 이동했습니다.");
    }

    public void removeAllEquipment() {
        for (EquipTypes types : equipmentBox.getAllEquipTypes()) {
            removeEquipment(types);
        }
        Play.println("모든 장비를 벗는데 성공하였습니다.");
    }

    public void changeUnitMutableStatus(UnitMutableStatusType type, int value) {
        switch (type) {
            case HP:
                unitStatus.changeHp(value);
                break;
            case MP:
                unitStatus.changeMp(value);
                break;
            case SP:
                unitStatus.changeSp(value);
                break;
            case EXP:
                if (unitStatus.changeExp(value)) {
                    skillBox.gainLevelUpSkillPoint();
                }
                break;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String unitInfo() {
        return "이름: " + name +
                "\n레벨: " + unitStatus.getLevel() +
                "\n체력: " + unitStatus.getHp() + "/" + unitStatus.getMaxHp() +
                "\n마나: " + unitStatus.getMp() + "/" + unitStatus.getMaxMp() +
                "\n스테미나: " + unitStatus.getSp() + "/" + unitStatus.getMaxSp() +
                "\n경험치: " + unitStatus.getExp() + "/" + UnitStatus.maxExp +
                "\n스킬(레벨): " + skillBox.toString() +
                "\n스킬 포인트: " + skillBox.getSkillPoint() +
                "\n장비: " + equipmentBox.toString();
    }
}
