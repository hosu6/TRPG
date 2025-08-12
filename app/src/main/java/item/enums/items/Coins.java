package item.enums.items;

import item.interfaces.Item;

public enum Coins implements Item {
    COPPER_COIN("동화", "가장 낮은 가치의 화폐", 0.1, 1),
    SILVER_COIN("은화", "중간 가치의 화폐", 0.2, 100),
    GOLD_COIN("금화", "높은 가치의 화폐", 0.3, 10000),
    PLATINUM_COIN("백금화", "최고 가치의 화폐", 0.4, 1000000);

    private String name;
    private String info;
    private double weight;
    private int value;

    Coins(String name, String info, double weight, int value) {
        this.name = name;
        this.info = info;
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}