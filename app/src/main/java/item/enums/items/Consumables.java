package item.enums.items;

import item.interfaces.Item;
import lombok.Getter;

@Getter
public enum Consumables implements Item {
    RED_POTION("빨간약", "체력 회복용 포션", 0.5, 10),
    BLUE_POTION("파란약", "마나 회복용 포션", 0.5, 20),
    ;
    private final String name;
    private final String info;
    private final double weight;
    private final int value;

    Consumables(String name, String info, double weight, int value) {
        this.name = name;
        this.info = info;
        this.weight = weight;
        this.value = value;
    }
}
