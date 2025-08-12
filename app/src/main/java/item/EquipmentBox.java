package item;

import exception.item.AccessNotExistItemException;
import exception.item.AlreadyEquippedItemException;
import exception.item.NotEquitableItemException;
import exception.item.TwoHandedWeaponConflictException;
import item.enums.EquipTypes;
import item.enums.items.Equipments;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class EquipmentBox {

    private final HashMap<EquipTypes, Equipments> equipmentBox;

    public EquipmentBox(HashMap<EquipTypes, Equipments> equipmentBox) {
        this.equipmentBox = equipmentBox;
    }

    public EquipmentBox() {
        this.equipmentBox = new HashMap<>();
        for (EquipTypes equipType : EquipTypes.values()) {
            equipmentBox.put(equipType, Equipments.NONE);
        }
    }

    public EquipmentBox copy() {
        return new EquipmentBox((HashMap<EquipTypes, Equipments>) equipmentBox.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentBox that = (EquipmentBox) o;
        return Objects.equals(equipmentBox, that.equipmentBox);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(equipmentBox);
    }

    public Iterable<Equipments> getAllEquipments() {
        return equipmentBox.values();
    }

    public Equipments get(EquipTypes type) {
        return equipmentBox.get(type);
    }

    public Set<EquipTypes> getAllEquipTypes() {
        return equipmentBox.keySet();
    }

    public void addEquipment(Equipments equipment) {
        EquipTypes equipType = equipment.getEquipType();
        Equipments twoHandItem = equipmentBox.get(EquipTypes.TWO_HAND);
        Equipments mainHandItem = equipmentBox.get(EquipTypes.MAIN_HAND);
        Equipments offHandItem = equipmentBox.get(EquipTypes.OFF_HAND);
        if (equipmentBox.get(equipType) != null) {
            throw new AlreadyEquippedItemException("이미 " + equipType.name() + "장비가 장착되어 있습니다.");
        }
        switch (equipType) {
            case EquipTypes.NOT_EQUITABLE:
                throw new NotEquitableItemException(equipment.getName() + "은(는) 장착할 수 없는 아이템입니다.");
            case EquipTypes.MAIN_HAND, EquipTypes.OFF_HAND:
                if (twoHandItem != null)
                    throw new TwoHandedWeaponConflictException("이미 양손무기를 장착한 상태에서 한손 무기나 보조 무기는 장착할 수 없습니다.");
                break;
            case TWO_HAND:
                if (mainHandItem != null || offHandItem != null)
                    throw new TwoHandedWeaponConflictException("양손무기 장착 시에 양 손이 비어 있어야 합니다.");
                break;
        }
        equipmentBox.put(equipType, equipment);
    }

    public void removeEquipment(EquipTypes type) {
        if (type == EquipTypes.NOT_EQUITABLE) {
            throw new NotEquitableItemException(EquipTypes.NOT_EQUITABLE + "장비는 착용/착용 해제가 불가합니다.");
        }
        if (!equipmentBox.containsKey(type)) {
            throw new AccessNotExistItemException(type + "슬롯에 장착된 장비가 없습니다");
        }
        equipmentBox.remove(type);
    }

    @Override
    public String toString() {
        return "장착한 아이템들 출력 " + equipmentBox;
    }
}
