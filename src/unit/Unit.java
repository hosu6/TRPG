package unit;

import item.EquipmentBox;
import item.ItemBox;
import item.enums.EquipTypes;
import item.enums.Items;
import skill.SkillBox;
import status.UnitStatus;
import status.enums.UnitMutableStatusType;
import unit.enums.UnitType;

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
    }

    public void updateUnitStatus() {
        this.unitStatus.updateEffectiveStatus(equipmentBox);
    }

    public Unit clone() {
        return new Unit(type, name, itemBox.clone(), equipmentBox.clone(), skillBox.clone(), unitStatus.clone());
    }

    public void addEquipment(Items item) {
        try {
            equipmentBox.addEquipment(item, itemBox);
            updateUnitStatus();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeEquipment(EquipTypes type) {
        try {
            equipmentBox.removeEquipment(type, itemBox);
            updateUnitStatus();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println(type + "장비를 벗는데 실패하거나 장착효과를 반영하는데 실패하였습니다.");
        }
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

    public UnitType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public ItemBox getItemBox() {
        return itemBox;
    }

    public EquipmentBox getEquipmentBox() {
        return equipmentBox;
    }

    public SkillBox getSkillBox() {
        return skillBox;
    }

    public UnitStatus getUnitStatus() {
        return unitStatus;
    }
}
