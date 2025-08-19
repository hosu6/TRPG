package item.enums.items;

import item.interfaces.Item;
import lombok.Getter;

@Getter
public enum Materials implements Item {
    IRON_ORE("철광석", "철 주괴로 가공할 수 있는 광석", 1.0, 10),
    IRON_BAR("철주괴", "철로 이루어진 장비나 자재를 만들 수 있는 주괴", 1.0, 100);
    private final String name;
    private final String info;
    private final double weight;
    private final int value;

    Materials(String name, String info, double weight, int value) {
        this.name = name;
        this.info = info;
        this.weight = weight;
        this.value = value;
    }
}