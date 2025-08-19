package item.enums.items;

import item.interfaces.Item;
import lombok.Getter;

@Getter
public enum Misc implements Item {
    KEY("열쇠", "문을 잠그거나 열 수 있는 열쇠", 0.5, 10);
    private final String name;
    private final String info;
    private final double weight;
    private final int value;

    Misc(String name, String info, double weight, int value) {
        this.name = name;
        this.info = info;
        this.weight = weight;
        this.value = value;
    }
}