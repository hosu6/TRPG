package item;

import exception.common.NotEnoughQuantityException;
import exception.common.QuantityUnderZeroException;
import exception.item.AccessNotExistItemBoxException;
import item.enums.items.*;
import item.interfaces.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemBoxTest {

    private ItemBox itemBox;

    @BeforeEach
    void setUp() {
        itemBox = new ItemBox();
    }

    private enum TestItem implements Item {
        ITEM1, ITEM2, ITEM3;

        @Override
        public String getName() {
            return "";
        }

        @Override
        public String getInfo() {
            return "";
        }

        @Override
        public int getValue() {
            return 0;
        }

        @Override
        public double getWeight() {
            return 0;
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