package unit;

public class UnitBox {
    private final Unit unit;
    private int quantity;

    public UnitBox(Unit unit, int quantity) {
        this.unit = unit;
        this.quantity = quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }
}
