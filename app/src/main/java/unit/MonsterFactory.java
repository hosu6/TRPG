package unit;

import item.EquipmentBox;
import item.ItemBox;
import item.enums.items.Coins;
import item.enums.items.Equipments;
import skill.SkillBox;
import skill.enums.Skills;
import status.BaseStatus;
import status.UnitStatus;
import unit.enums.UnitType;

final public class MonsterFactory {
    public static Unit scarecrow(int level) {
        return new Unit(UnitType.GROUND,
                "허수아비",
                new ItemBox(),
                new EquipmentBox(),
                new SkillBox(),
                new UnitStatus(BaseStatus.tankStatusAtLevel(level), level));
    }

    public static Unit wyvern(int level) {
        ItemBox itemBox = new ItemBox();
        itemBox.addInventoryItem(Coins.SILVER_COIN, 2 * level);
        return new Unit(UnitType.GROUND,
                "와이번",
                itemBox,
                new EquipmentBox(),
                new SkillBox(Skills.BREATH, 3),
                new UnitStatus(BaseStatus.casterStatusAtLevel(level), level));
    }

    public static Unit corruptedDarkElf(int level) {
        ItemBox itemBox = new ItemBox();
        itemBox.addInventoryItem(Coins.SILVER_COIN, level);
        EquipmentBox equipmentBox = new EquipmentBox();
        equipmentBox.addEquipment(Equipments.ARMOR);
        equipmentBox.addEquipment(Equipments.BOW);
        return new Unit(UnitType.GROUND,
                "타락한 다크 엘프",
                itemBox,
                equipmentBox,
                new SkillBox(Skills.HARD_ATTACK, 5),
                new UnitStatus(BaseStatus.rangedDpsStatusAtLevel(level), level));
    }

    public static Unit goblin(int level) {
        ItemBox itemBox = new ItemBox();
        itemBox.addInventoryItem(Coins.COPPER_COIN, level);
        EquipmentBox equipmentBox = new EquipmentBox();
        equipmentBox.addEquipment(Equipments.SWORD);
        return new Unit(UnitType.GROUND,
                "고블린",
                itemBox,
                equipmentBox,
                new SkillBox(Skills.HARD_ATTACK, 1),
                new UnitStatus(BaseStatus.rogueStatusAtLevel(level), level));
    }

    public static Unit skeletonSoldier(int level) {
        ItemBox itemBox = new ItemBox();
        itemBox.addInventoryItem(Coins.COPPER_COIN, 3 * level);
        EquipmentBox equipmentBox = new EquipmentBox();
        equipmentBox.addEquipment(Equipments.ARMOR);
        equipmentBox.addEquipment(Equipments.SWORD);
        equipmentBox.addEquipment(Equipments.SHIELD);
        return new Unit(UnitType.GROUND,
                "해골병사",
                itemBox,
                equipmentBox,
                new SkillBox(Skills.HARD_ATTACK, 1),
                new UnitStatus(BaseStatus.meleeDpsStatusAtLevel(level), level));
    }

    public static Unit lizardMan(int level) {
        ItemBox itemBox = new ItemBox();
        itemBox.addInventoryItem(Coins.COPPER_COIN, 2 * level);
        EquipmentBox equipmentBox = new EquipmentBox();
        equipmentBox.addEquipment(Equipments.SWORD);
        return new Unit(UnitType.GROUND,
                "리자드맨",
                itemBox,
                equipmentBox,
                new SkillBox(Skills.HARD_ATTACK, 3),
                new UnitStatus(BaseStatus.meleeDpsStatusAtLevel(level), level));
    }
}