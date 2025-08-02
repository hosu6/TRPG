package item;

import item.enums.EquipTypes;
import item.enums.Items;

import java.util.HashMap;

public class EquipmentBox {

    private final HashMap<EquipTypes, Items> equipmentBox;

    public EquipmentBox(HashMap<EquipTypes, Items> equipmentBox) {
        this.equipmentBox = equipmentBox;
    }

    public EquipmentBox clone() {
        return new EquipmentBox((HashMap<EquipTypes, Items>) equipmentBox.clone());
    }

    public Iterable<Items> getAllEquipments() {
        return equipmentBox.values();
    }

    public void addEquipment(Items item, ItemBox itemBox) {
        EquipTypes equipType = item.getItem().getItemType().getEquipType();
        if (equipType == EquipTypes.NOT_EQUITABLE) {
            throw new IllegalArgumentException(item.getItem().getName() + "은(는) 장착할 수 없는 아이템입니다.");
        }
        // 해당 슬롯에 이미 장비가 있다면 인벤토리로 되돌림
        if (equipmentBox.containsKey(equipType)) {
            removeEquipment(equipType, itemBox);
        }
        // 인벤토리 장비를 장착
        itemBox.removeInventoryItem(item, 1);
        equipmentBox.put(equipType, item);
        System.out.println(item.getItem().getName() + "을(를) 장착했습니다.");
    }

    public void removeEquipment(EquipTypes type, ItemBox itemBox) {
        if (type == EquipTypes.NOT_EQUITABLE) {
            throw new IllegalArgumentException(EquipTypes.NOT_EQUITABLE + "장비는 착용/착용 해제가 불가합니다.");
        }
        if (!equipmentBox.containsKey(type)) {
            throw new IllegalArgumentException(type + "슬롯에 장착된 장비가 없습니다");
        }
        Items itemToRemove = equipmentBox.get(type);
        itemBox.addInventoryItem(itemToRemove, 1);
        equipmentBox.remove(type);
        System.out.println(itemToRemove.getItem().getName() + "을(를) 벗어 인벤토리로 이동했습니다.");
    }

    public void removeAllEquipment(ItemBox itemBox) {
        try {
            for (EquipTypes equipType : equipmentBox.keySet()) {
                removeEquipment(equipType, itemBox);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("모든 장비를 벗는데 실패하였습니다.");
        }
    }
}
