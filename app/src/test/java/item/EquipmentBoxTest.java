package item;

import item.enums.EquipTypes;
import item.enums.Items;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentBoxTest {

    private EquipmentBox equipmentBox;

    @BeforeEach
    void setUp() {
        equipmentBox = new EquipmentBox();
    }

    @Test
    void testClone() {
        equipmentBox.addEquipment(Items.IRON_SWORD);
        equipmentBox.addEquipment(Items.IRON_SHIELD);
        equipmentBox.addEquipment(Items.IRON_HELMET);
        equipmentBox.addEquipment(Items.IRON_ARMOR);
        equipmentBox.addEquipment(Items.IRON_PANTS);
        equipmentBox.addEquipment(Items.IRON_GLOVES);
        equipmentBox.addEquipment(Items.IRON_BOOTS);
        equipmentBox.addEquipment(Items.SILVER_NECKLACE);
        equipmentBox.addEquipment(Items.SILVER_RING);

        EquipmentBox clone = equipmentBox.clone();
        assertEquals(equipmentBox, clone);
        assertNotSame(equipmentBox, clone);
        clone.removeEquipment(EquipTypes.MAIN_HAND);
        clone.addEquipment(Items.RUSTY_SWORD);
        assertNotEquals(equipmentBox, clone);
        assertNotSame(equipmentBox, clone);
    }

    @Test
    void addOneHandedSword_ShouldBeEquippedAndOtherSlotsAreNone() {
        // given
        Items itemToAdd = Items.IRON_SWORD;

        // when
        equipmentBox.addEquipment(itemToAdd);

        // then
        assertSame(itemToAdd, equipmentBox.get(EquipTypes.MAIN_HAND), "한손검이 올바르게 장착되어야 합니다.");
        // 장착되지 않은 모든 슬롯이 NONE인지 확인
        for (EquipTypes type : EquipTypes.values()) {
            if (type != EquipTypes.NOT_EQUITABLE && type != EquipTypes.MAIN_HAND) {
                assertSame(Items.NONE, equipmentBox.get(type), type + " 슬롯은 비어 있어야 합니다.");
            }
        }
    }

    @Test
    void addShield_ShouldBeEquippedAndOtherSlotsAreNone() {
        // given
        Items itemToAdd = Items.IRON_SHIELD;

        // when
        equipmentBox.addEquipment(itemToAdd);

        // then
        assertSame(itemToAdd, equipmentBox.get(EquipTypes.OFF_HAND), "방패가 올바르게 장착되어야 합니다.");
        // 장착되지 않은 모든 슬롯이 NONE인지 확인
        for (EquipTypes type : EquipTypes.values()) {
            if (type != EquipTypes.NOT_EQUITABLE && type != EquipTypes.OFF_HAND) {
                assertSame(Items.NONE, equipmentBox.get(type), type + " 슬롯은 비어 있어야 합니다.");
            }
        }
    }

    @Test
    void addEquipment_ShouldThrowExceptionIfSlotIsFull() {
        //given
        Items ironArmor = Items.IRON_ARMOR;
        equipmentBox.addEquipment(ironArmor);

        //when & then


    }

    @Test
    void addEquipment_ShouldThrowExceptionIfSlotIsOccupied() {
        // given
        equipmentBox.addEquipment(Items.IRON_SWORD);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            equipmentBox.addEquipment(Items.MAGIC_WAND);
        });

        assertTrue(exception.getMessage().contains("이미 MAIN_HAND장비가 장착되어 있습니다."));
    }

    @Test
    void addEquipment_ShouldThrowExceptionIfNotEquipable() {
        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            equipmentBox.addEquipment(Items.CARROT);
        });

        assertTrue(exception.getMessage().contains("은(는) 장착할 수 없는 아이템입니다."));
    }

    @Test
    void removeEquipment() {
    }

    @Test
    void removeAllEquipment() {
    }
}