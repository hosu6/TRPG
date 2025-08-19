package item.enums.items;

import item.interfaces.Item;
import lombok.Getter;

@Getter
public enum Valuables implements Item {
    GOLD_STATUE("금 조각상", "화려하게 장식된 금 조각상이다.", 10.0, 10000),
    ;
    private final String name;
    private final String info;
    private final double weight;
    private final int value;

    Valuables(String name, String info, double weight, int value) {
        this.name = name;
        this.info = info;
        this.weight = weight;
        this.value = value;
    }
}