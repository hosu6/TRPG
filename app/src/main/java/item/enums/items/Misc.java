package item.enums.items;

import item.interfaces.Item;

public enum Misc implements Item {
    KEY("열쇠", "문을 잠그거나 열 수 있는 열쇠", 0.5, 10)
    ;
    private String name;
    private String info;
    private double weight;
    private int value;

    Misc(String name, String info, double weight, int value) {
        this.name = name;
        this.info = info;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public double getWeight() {
        return 0;
    }
}