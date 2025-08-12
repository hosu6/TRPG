package item.enums.items;

import item.interfaces.Item;

public enum Valuables implements Item {
    GOLD_STATUE("금 조각상", "화려하게 장식된 금 조각상이다.", 10.0, 10000),
    ;
    private String name;
    private String info;
    private double weight;
    private int value;

    Valuables(String name, String info, double weight, int value) {
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