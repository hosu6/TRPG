package item;

import exception.common.NotEnoughQuantityException;
import exception.common.QuantityUnderZeroException;
import exception.item.AccessNotExistItemBoxException;
import item.enums.items.*;
import item.interfaces.Item;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemBoxTest {

    private ItemBox itemBox;

    @BeforeEach
    void setUp() {
        itemBox = new ItemBox();
    }

    @Getter
    private enum TestItem implements Item {
        ITEM1("item1", "item1 info", 1.0, 1),
        ITEM2("item2", "item2 info", 10.0, 10),
        ITEM3("item3", "item3 info", 100.0, 100),
        ;
        private final String name;
        private final String info;
        private final double weight;
        private final int value;
        private final int quantity = 100;

        TestItem(String name, String info, double weight, int value) {
            this.name = name;
            this.info = info;
            this.weight = weight;
            this.value = value;
        }
    }


    @Test
    void addAndRemoveInventoryItem() {
        assertThrows(QuantityUnderZeroException.class, () -> itemBox.addInventoryItem(Coins.COPPER_COIN, -10));
        assertThrows(QuantityUnderZeroException.class, () -> itemBox.removeInventoryItem(Coins.COPPER_COIN, 0));
        assertThrows(AccessNotExistItemBoxException.class, () -> itemBox.addInventoryItem(TestItem.ITEM1, 10));
        assertThrows(AccessNotExistItemBoxException.class, () -> itemBox.removeInventoryItem(TestItem.ITEM1, 10));
        assertThrows(NotEnoughQuantityException.class, () -> itemBox.removeInventoryItem(Coins.COPPER_COIN, 10));
        itemBox.addInventoryItem(Coins.COPPER_COIN, 10);
        itemBox.addInventoryItem(Consumables.RED_POTION, 10);
        itemBox.addInventoryItem(Equipments.SWORD, 10);
        itemBox.addInventoryItem(Materials.IRON_ORE, 10);
        itemBox.addInventoryItem(Misc.KEY, 10);
        itemBox.addInventoryItem(Valuables.GOLD_STATUE, 10);
        itemBox.addInventoryItem(Coins.COPPER_COIN, 10);
        assert itemBox.getQuantity(Coins.COPPER_COIN) == 20;
        assert itemBox.getQuantity(Consumables.RED_POTION) == 10;
        assert itemBox.getQuantity(Equipments.SWORD) == 10;
        assert itemBox.getQuantity(Materials.IRON_ORE) == 10;
        assert itemBox.getQuantity(Misc.KEY) == 10;
        assert itemBox.getQuantity(Valuables.GOLD_STATUE) == 10;
        itemBox.removeInventoryItem(Coins.COPPER_COIN, 5);
        assert itemBox.getQuantity(Coins.COPPER_COIN) == 15;
    }

    @Test
    void copy() {
        ItemBox itemBoxCopy = itemBox.copy();
        assert itemBox != itemBoxCopy;
        assert itemBox.equals(itemBoxCopy);
        itemBox.addInventoryItem(Coins.COPPER_COIN, 10);
        assert !itemBox.equals(itemBoxCopy);
        itemBox.removeInventoryItem(Coins.COPPER_COIN, 5);
        itemBoxCopy.addInventoryItem(Coins.COPPER_COIN, 5);
        assert itemBox.equals(itemBoxCopy);
    }
}