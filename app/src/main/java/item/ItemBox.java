package item;

import item.enums.Items;

import java.util.HashMap;

public class ItemBox {
    private final HashMap<Items, Integer> itemBox; //value=Item quantity in inventory, key=Item type enum value.

    public ItemBox(HashMap<Items, Integer> itemBox) {
        this.itemBox = itemBox;
    }

    public ItemBox(Items item, int quantity) {
        this.itemBox = new HashMap<>();
        addInventoryItem(item, quantity);
    }

    public void addInventoryItem(Items item, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("인벤토리에 저장하는 아이템 수량은 1이상이어야 합니다.");
        itemBox.put(item, itemBox.getOrDefault(item, 0) + quantity);
    }

    public ItemBox clone() {
        return new ItemBox((HashMap<Items, Integer>) itemBox.clone());
    }

    public void printAllItems() {
        for (Items item : itemBox.keySet()) {
            System.out.println(item.getItem().getName() + "이(가) " + itemBox.get(item) + "개 있습니다.");
        }
    }

    public void removeInventoryItem(Items item, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("인벤토리에 저장하는 아이템 수량은 1 이상이어야 합니다.");
        if (!itemBox.containsKey(item)) throw new IllegalArgumentException("제거하려는 아이템이 인벤토리에 존재하지 않습니다.");
        int remaining = itemBox.get(item) - quantity;
        if (remaining == 0) {
            itemBox.remove(item);
        } else if (remaining > 0) {
            itemBox.put(item, remaining);
        } else {
            throw new IllegalArgumentException("인벤토리의 " + item.getItem().getName() + " 수량이 " + quantity + "개보다 적습니다.");
        }
    }
}
