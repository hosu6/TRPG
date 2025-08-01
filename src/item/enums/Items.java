package item.enums;

import item.Equipment;
import item.Item;
import unit.Status;

public enum Items {
    // --- 무기류 (WEAPONS) ---
    // 한손검
    RUSTY_SWORD(new Equipment("Rusty Sword", 2.5, 10, ItemTypes.ONE_HANDED_SWORD, 10, 0, Status.EMPTY_STATUS)),

    // 포션
    RED_POTION(new Item("Red Potion", 0.5, 10, ItemTypes.POTION)),
    ;
    final Item item;

    Items(Item item) {
        this.item = item;
    }
    public Item getItem() {
        return item;
    }
}
