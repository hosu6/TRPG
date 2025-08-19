package item.enums.items;

import item.interfaces.Item;
import lombok.Getter;

@Getter
public enum Coins implements Item {
    COPPER_COIN("동화", "가장 낮은 가치의 화폐", 0.1, 1),
    SILVER_COIN("은화", "중간 가치의 화폐", 0.2, 100),
    GOLD_COIN("금화", "높은 가치의 화폐", 0.3, 10000),
    PLATINUM_COIN("백금화", "최고 가치의 화폐", 0.4, 1000000);

    private final String name;
    private final String info;
    private final double weight;
    private final int value;

    Coins(String name, String info, double weight, int value) {
        this.name = name;
        this.info = info;
        this.weight = weight;
        this.value = value;
    }
}