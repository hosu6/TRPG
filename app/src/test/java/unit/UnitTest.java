package unit;

import item.EquipmentBox;
import item.ItemBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skill.SkillBox;
import status.BaseStatus;
import status.UnitStatus;
import unit.enums.UnitType;

class UnitTest {

    private Unit unit;

    @BeforeEach
    void setUp() {
        BaseStatus baseStatus = new BaseStatus(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        UnitStatus unitStatus = new UnitStatus(baseStatus, 1);
        unit = new Unit(UnitType.GROUND, "허수아비", new ItemBox(), new EquipmentBox(), new SkillBox(), unitStatus);
    }

    @Test
    void updateUnitStatus() {
    }

    @Test
    void copy() {
    }

    @Test
    void addEquipment() {
    }

    @Test
    void removeEquipment() {
    }

    @Test
    void removeAllEquipment() {
    }

    @Test
    void changeUnitMutableStatus() {
    }
}