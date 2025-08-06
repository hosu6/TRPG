package item;

import item.enums.ItemTypes;

public class Item {
    private final String name;
    private final double weight;
    private final int value;
    private final ItemTypes itemType;

    public Item(String name, double weight, int value, ItemTypes itemType) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.itemType = itemType;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public ItemTypes getItemType() {
        return itemType;
    }
}
