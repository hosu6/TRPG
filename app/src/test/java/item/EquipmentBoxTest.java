package item;

import exception.item.AlreadyEquippedItemException;
import exception.item.TwoHandedWeaponConflictException;
import item.enums.EquipTypes;
import item.enums.items.Equipments;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class EquipmentBoxTest {

    private EquipmentBox equipmentBox;

    @BeforeEach
    void setUp() {
        equipmentBox = new EquipmentBox();
    }

    @Test
    void copy() {
        //copy 이후 비교
        EquipmentBox equipmentBoxCopy = equipmentBox.copy();
        assert equipmentBoxCopy.getCount() == 0;
        assert equipmentBox.getCount() == 0;
        assert equipmentBoxCopy != equipmentBox;
        assert equipmentBoxCopy.equals(equipmentBox);

        //장비 추가 후 비교
        equipmentBox.addEquipment(Equipments.SWORD);
        equipmentBox.addEquipment(Equipments.SHIELD);
        equipmentBox.addEquipment(Equipments.HELMET);
        equipmentBox.addEquipment(Equipments.AMULET);
        equipmentBox.addEquipment(Equipments.RING);
        equipmentBox.addEquipment(Equipments.GREAVES);
        equipmentBox.addEquipment(Equipments.BOOTS);
        equipmentBox.addEquipment(Equipments.GAUNTLETS);
        assert equipmentBoxCopy.getCount() == 0;
        assert equipmentBox.getCount() == 8;
        assert !equipmentBoxCopy.equals(equipmentBox);

        //copy 이후 비교
        equipmentBoxCopy = equipmentBox.copy();
        assert equipmentBoxCopy.getCount() == 8;
        assert equipmentBox.getCount() == 8;
        assert equipmentBoxCopy.equals(equipmentBox);

        // 복사본을 수정 후 비교
        equipmentBoxCopy.removeEquipment(EquipTypes.MAIN_HAND);
        assert equipmentBoxCopy.getCount() == 7;
        assert equipmentBox.getCount() == 8;
        assert !equipmentBox.equals(equipmentBoxCopy);
    }

    @Test
    void addEquipmentAndRemoveEquipment() {
        equipmentBox.addEquipment(Equipments.SWORD);
        equipmentBox.addEquipment(Equipments.SHIELD);
        assert equipmentBox.getCount() == 2;
        assertThrows(AlreadyEquippedItemException.class, () -> equipmentBox.addEquipment(Equipments.SWORD));
        assertThrows(AlreadyEquippedItemException.class, () -> equipmentBox.addEquipment(Equipments.SHIELD));
        assertThrows(TwoHandedWeaponConflictException.class, () -> equipmentBox.addEquipment(Equipments.GREAT_SWORD));
        equipmentBox.removeEquipment(EquipTypes.MAIN_HAND);
        assert equipmentBox.getCount() == 1;
        assertThrows(TwoHandedWeaponConflictException.class, () -> equipmentBox.addEquipment(Equipments.GREAT_SWORD));
        equipmentBox.removeEquipment(EquipTypes.OFF_HAND);
        assert equipmentBox.getCount() == 0;
        equipmentBox.addEquipment(Equipments.GREAT_SWORD);
        assert equipmentBox.getCount() == 1;
        assertThrows(TwoHandedWeaponConflictException.class, () -> equipmentBox.addEquipment(Equipments.SWORD));
        assertThrows(TwoHandedWeaponConflictException.class, () -> equipmentBox.addEquipment(Equipments.SHIELD));
    }
}