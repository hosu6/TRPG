package item.enums;

public enum ItemTypes {
    // 무기류 (WEAPONS)
    ONE_HANDED_SWORD("One-Handed Sword", ItemCategorys.WEAPONS, EquipTypes.MAIN_HAND),
    TWO_HANDED_SWORD("Two-Handed Sword", ItemCategorys.WEAPONS, EquipTypes.TWO_HAND),
    BOW("Bow", ItemCategorys.WEAPONS, EquipTypes.TWO_HAND),
    WAND("Wand", ItemCategorys.WEAPONS, EquipTypes.MAIN_HAND),
    SPEAR("Spear", ItemCategorys.WEAPONS, EquipTypes.TWO_HAND),
    LANCE("Lance", ItemCategorys.WEAPONS, EquipTypes.TWO_HAND),

    // 방어구류 (ARMOR)
    HELMET("Helmet", ItemCategorys.ARMOR, EquipTypes.HEAD),
    BODY_ARMOR("Body Armor", ItemCategorys.ARMOR, EquipTypes.TORSO),
    PANTS("Pants", ItemCategorys.ARMOR, EquipTypes.LEGS),
    GLOVES("Gloves", ItemCategorys.ARMOR, EquipTypes.HANDS),
    BOOTS("Boots", ItemCategorys.ARMOR, EquipTypes.FEET),
    SHIELD("Shield", ItemCategorys.ARMOR, EquipTypes.OFF_HAND), // 방패는 보조 손에 장착

    // 장신구류 (ACCESSORIES)
    NECKLACE("Necklace", ItemCategorys.ACCESSORIES, EquipTypes.NECK),
    RING("Ring", ItemCategorys.ACCESSORIES, EquipTypes.FINGER),

    // 소모품류 (CONSUMABLES)
    POTION("Potion", ItemCategorys.CONSUMABLES, EquipTypes.NOT_EQUITABLE),
    SCROLL("Scroll", ItemCategorys.CONSUMABLES, EquipTypes.NOT_EQUITABLE),
    FOOD("Food", ItemCategorys.CONSUMABLES, EquipTypes.NOT_EQUITABLE),
    THROWING_WEAPON("Throwing Weapon", ItemCategorys.CONSUMABLES, EquipTypes.NOT_EQUITABLE), // 소모성 무기로 간주
    BOMB("Bomb", ItemCategorys.CONSUMABLES, EquipTypes.NOT_EQUITABLE),

    // 금품 (VALUABLES)
    CURRENCY("Gold Coin", ItemCategorys.VALUABLES, EquipTypes.NOT_EQUITABLE),
    GEM("Gem", ItemCategorys.VALUABLES, EquipTypes.NOT_EQUITABLE),
    JEWEL("Jewel", ItemCategorys.VALUABLES, EquipTypes.NOT_EQUITABLE),

    // 몬스터 부산물 (MISC - 편의상 여기에 포함)
    MONSTER_DROP("Monster Drop", ItemCategorys.MISC, EquipTypes.NOT_EQUITABLE),
    MONSTER_PART("Monster Part", ItemCategorys.MISC, EquipTypes.NOT_EQUITABLE),
    MONSTER_BYPRODUCT("Monster Byproduct", ItemCategorys.MISC, EquipTypes.NOT_EQUITABLE),

    // 기타 (MISC)
    MISCELLANEOUS("Miscellaneous", ItemCategorys.MISC, EquipTypes.NOT_EQUITABLE);

    private final String name; // 아이템의 사용자 친화적인 이름
    private final ItemCategorys category; // 아이템 분류 (무기, 방어구 등)
    private final EquipTypes equipType; // 장착 타입 (투구, 손, 장착 불가 등)

    ItemTypes(String name, ItemCategorys category, EquipTypes equipType) {
        this.name = name;
        this.category = category;
        this.equipType = equipType;
    }

    // Getter 메서드들
    public String getName() {
        return name;
    }

    public ItemCategorys getCategory() {
        return category;
    }

    public EquipTypes getEquipType() {
        return equipType;
    }

    // (선택 사항) toString 오버라이드 (디버깅 편의를 위해)
    @Override
    public String toString() {
        return name + " (Category: " + category + ", Equip: " + equipType + ")";
    }
}
