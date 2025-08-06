package item.enums;

import item.Equipment;
import item.Item;
import status.BaseStatus;

public enum Items {
    // 아이템이 없는 상태
    NONE(new Item("None", 0, 0, ItemTypes.MISCELLANEOUS)),

    // --- 무기류 (WEAPONS) ---
    // 한손검 (ONE_HANDED_SWORD)
    RUSTY_SWORD(new Equipment("Rusty Sword", 2.5, 10, ItemTypes.ONE_HANDED_SWORD, 10, 0, BaseStatus.EMPTY_BASE_STATUS)),
    IRON_SWORD(new Equipment("Iron Sword", 3.0, 50, ItemTypes.ONE_HANDED_SWORD, 15, 0, BaseStatus.EMPTY_BASE_STATUS)),

    // 양손검 (TWO_HANDED_SWORD)
    GREAT_SWORD(new Equipment("Great Sword", 10.0, 150, ItemTypes.TWO_HANDED_SWORD, 30, 0, BaseStatus.EMPTY_BASE_STATUS)),
    CLAYMORE(new Equipment("Claymore", 12.0, 200, ItemTypes.TWO_HANDED_SWORD, 35, 0, BaseStatus.EMPTY_BASE_STATUS)),

    // 활 (BOW)
    SHORT_BOW(new Equipment("Short Bow", 2.0, 40, ItemTypes.BOW, 12, 0, BaseStatus.EMPTY_BASE_STATUS)),
    LONG_BOW(new Equipment("Long Bow", 3.5, 90, ItemTypes.BOW, 20, 0, BaseStatus.EMPTY_BASE_STATUS)),

    // 완드 (WAND)
    WOODEN_WAND(new Equipment("Wooden Wand", 1.0, 20, ItemTypes.WAND, 5, 0, BaseStatus.EMPTY_BASE_STATUS)),
    MAGIC_WAND(new Equipment("Magic Wand", 1.2, 70, ItemTypes.WAND, 15, 0, BaseStatus.EMPTY_BASE_STATUS)),

    // 창 (SPEAR)
    WOODEN_SPEAR(new Equipment("Wooden Spear", 4.0, 30, ItemTypes.SPEAR, 18, 0, BaseStatus.EMPTY_BASE_STATUS)),
    IRON_SPEAR(new Equipment("Iron Spear", 5.0, 80, ItemTypes.SPEAR, 25, 0, BaseStatus.EMPTY_BASE_STATUS)),

    // --- 방어구류 (ARMOR) ---
    // 헬멧 (HELMET)
    LEATHER_HELMET(new Equipment("Leather Helmet", 1.0, 15, ItemTypes.HELMET, 0, 5, BaseStatus.EMPTY_BASE_STATUS)),
    IRON_HELMET(new Equipment("Iron Helmet", 3.0, 60, ItemTypes.HELMET, 0, 15, BaseStatus.EMPTY_BASE_STATUS)),

    // 갑옷 (BODY_ARMOR)
    LEATHER_ARMOR(new Equipment("Leather Armor", 5.0, 40, ItemTypes.BODY_ARMOR, 0, 15, BaseStatus.EMPTY_BASE_STATUS)),
    IRON_ARMOR(new Equipment("Iron Armor", 15.0, 150, ItemTypes.BODY_ARMOR, 0, 40, BaseStatus.EMPTY_BASE_STATUS)),

    // 바지 (PANTS)
    LEATHER_PANTS(new Equipment("Leather Pants", 3.0, 25, ItemTypes.PANTS, 0, 8, BaseStatus.EMPTY_BASE_STATUS)),
    IRON_PANTS(new Equipment("Iron Pants", 8.0, 80, ItemTypes.PANTS, 0, 20, BaseStatus.EMPTY_BASE_STATUS)),

    // 장갑 (GLOVES)
    LEATHER_GLOVES(new Equipment("Leather Gloves", 0.5, 10, ItemTypes.GLOVES, 0, 3, BaseStatus.EMPTY_BASE_STATUS)),
    IRON_GLOVES(new Equipment("Iron Gloves", 1.5, 40, ItemTypes.GLOVES, 0, 10, BaseStatus.EMPTY_BASE_STATUS)),

    // 신발 (BOOTS)
    LEATHER_BOOTS(new Equipment("Leather Boots", 1.0, 10, ItemTypes.BOOTS, 0, 3, BaseStatus.EMPTY_BASE_STATUS)),
    IRON_BOOTS(new Equipment("Iron Boots", 2.0, 50, ItemTypes.BOOTS, 0, 12, BaseStatus.EMPTY_BASE_STATUS)),

    // 방패 (SHIELD)
    WOODEN_SHIELD(new Equipment("Wooden Shield", 2.0, 25, ItemTypes.SHIELD, 0, 10, BaseStatus.EMPTY_BASE_STATUS)),
    IRON_SHIELD(new Equipment("Iron Shield", 5.0, 70, ItemTypes.SHIELD, 0, 20, BaseStatus.EMPTY_BASE_STATUS)),

    // --- 장신구류 (ACCESSORIES) ---
    // 목걸이 (NECKLACE)
    SILVER_NECKLACE(new Equipment("Silver Necklace", 0.1, 50, ItemTypes.NECKLACE, 0, 0, BaseStatus.EMPTY_BASE_STATUS)),
    GOLD_NECKLACE(new Equipment("Gold Necklace", 0.2, 120, ItemTypes.NECKLACE, 0, 0, BaseStatus.EMPTY_BASE_STATUS)),

    // 반지 (RING)
    SILVER_RING(new Equipment("Silver Ring", 0.05, 30, ItemTypes.RING, 0, 0, BaseStatus.EMPTY_BASE_STATUS)),
    GOLD_RING(new Equipment("Gold Ring", 0.1, 80, ItemTypes.RING, 0, 0, BaseStatus.EMPTY_BASE_STATUS)),

    // --- 소모품류 (CONSUMABLES) ---
    // 포션 (POTION)
    RED_POTION(new Item("Red Potion", 0.5, 10, ItemTypes.POTION)),
    BLUE_POTION(new Item("Blue Potion", 0.5, 15, ItemTypes.POTION)),

    // 음식 (FOOD)
    CARROT(new Item("Carrot", 0.5, 10, ItemTypes.FOOD)),
    APPLE(new Item("Apple", 0.3, 8, ItemTypes.FOOD)),
    ;
    final Item item;

    Items(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
}
