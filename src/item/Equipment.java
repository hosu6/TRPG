package item;

import item.enums.ItemTypes;
import unit.Status;

public class Equipment extends Item{
    private final int atk;
    private final int def;
    private final Status status; //스테이터스 보정치

    public Equipment(String name, double weight, int value, ItemTypes itemType, int atk, int def, Status status) {
        super(name, weight, value, itemType);
        this.atk = atk;
        this.def = def;
        this.status = status;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public Status getStatus() {
        return status.copy();
    }
}
