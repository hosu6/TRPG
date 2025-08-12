package item.enums.items;

import item.interfaces.Item;

public enum Materials implements Item {
    ;
    private String name;
    private String info;
    private double weight;
    private int value;

    Materials(String name, String info, double weight, int value) {
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