package unit.enums;

import item.EquipmentBox;
import item.ItemBox;
import skill.SkillBox;
import skill.enums.Skills;
import status.BaseStatus;
import status.UnitStatus;
import unit.Unit;

public enum Monsters {
    SCARECROW(new Unit(UnitType.GROUND,
            "허수아비",
            new ItemBox(),
            new EquipmentBox(),
            new SkillBox(),
            new UnitStatus(BaseStatus.EMPTY_BASE_STATUS, 1))),
    SKELETON_SOLDIER(new Unit(UnitType.GROUND,
            "해골병사",
            new ItemBox(),
            new EquipmentBox(),
            new SkillBox(Skills.HARD_ATTACK, 1),
            new UnitStatus(BaseStatus.EMPTY_BASE_STATUS, 1))),
    WYVERN(new Unit(UnitType.GROUND,
            "와이번",
            new ItemBox(),
            new EquipmentBox(),
            new SkillBox(Skills.BREATH, 3),
            new UnitStatus(BaseStatus.EMPTY_BASE_STATUS, 1))),
    LIZARD_MAN(new Unit(UnitType.GROUND,
            "리자드맨",
            new ItemBox(),
            new EquipmentBox(),
            new SkillBox(Skills.HARD_ATTACK, 3),
            new UnitStatus(BaseStatus.EMPTY_BASE_STATUS, 1))),
    ;
    private final Unit unit;

    Monsters(Unit unit) {
        this.unit = unit;
    }
}
