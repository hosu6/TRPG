package item;

import item.enums.ItemTypes;
import status.BaseStatus;

public class Equipment extends Item {
    private final int atk;
    private final int def;
    private final BaseStatus baseStatus; //스테이터스 보정치

    public Equipment(String name, double weight, int value, ItemTypes itemType, int atk, int def, BaseStatus baseStatus) {
        super(name, weight, value, itemType);
        this.atk = atk;
        this.def = def;
        this.baseStatus = baseStatus;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public BaseStatus getStatus() {
        return baseStatus.clone();
    }
}
