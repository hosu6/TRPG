package item;

import exception.common.NotEnoughQuantityException;
import exception.common.QuantityUnderZeroException;
import exception.item.AccessNotExistItemBoxException;
import item.enums.items.*;
import item.interfaces.Item;
import play.Play;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemBox {

    private final Map<Class<? extends Item>, Map<Item, Integer>> itemBoxes;

    public ItemBox() {
        itemBoxes = new HashMap<>();
        itemBoxes.put(Consumables.class, new HashMap<>());
        itemBoxes.put(Equipments.class, new HashMap<>());
        itemBoxes.put(Materials.class, new HashMap<>());
        itemBoxes.put(Misc.class, new HashMap<>());
        itemBoxes.put(Valuables.class, new HashMap<>());
        itemBoxes.put(Coins.class, new HashMap<>());
    }

    private ItemBox(Map<Class<? extends Item>, Map<Item, Integer>> itemBoxes) {
        this.itemBoxes = itemBoxes;
    }

    public void addInventoryItem(Item item, int quantity) {
        if (quantity <= 0) throw new QuantityUnderZeroException("인벤토리에 저장하는 아이템 수량은 1 이상이어야 합니다.");
        if (item == null) return;
        Map<Item, Integer> box = getItemMap(item);
        box.put(item, box.getOrDefault(item, 0) + quantity);
    }

    public void removeInventoryItem(Item item, int quantity) {
        if (quantity <= 0) throw new QuantityUnderZeroException("제거하는 아이템 수량은 1 이상이어야 합니다.");

        Map<Item, Integer> box = getItemMap(item);

        int currentQuantity = box.getOrDefault(item, 0);
        if (currentQuantity < quantity) throw new NotEnoughQuantityException("제거하려는 아이템의 수량이 소지한 수량보다 많습니다.");

        int newQuantity = currentQuantity - quantity;
        if (newQuantity == 0) {
            box.remove(item);
        } else {
            box.put(item, newQuantity);
        }
    }

    private Map<Item, Integer> getItemMap(Item item) {
        Map<Item, Integer> box = itemBoxes.get(item.getClass());
        if (box == null) throw new AccessNotExistItemBoxException("지원하지 않는 아이템 박스입니다: " + item.getClass().getName());
        return box;
    }

    public int getQuantity(Item item) {
        Map<Item, Integer> box = getItemMap(item);
        return box.get(item);
    }

    public void printAllItems() {
        for (Map.Entry<Class<? extends Item>, Map<Item, Integer>> entry : itemBoxes.entrySet()) {
            Play.println(entry.getKey().getSimpleName() + " : " + entry.getValue());
        }
    }

    public ItemBox copy() {
        Map<Class<? extends Item>, Map<Item, Integer>> clonedBoxes = new HashMap<>();
        for (Map.Entry<Class<? extends Item>, Map<Item, Integer>> entry : itemBoxes.entrySet()) {
            clonedBoxes.put(entry.getKey(), new HashMap<>(entry.getValue()));
        }
        return new ItemBox(clonedBoxes);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemBox itemBox = (ItemBox) o;
        return Objects.equals(itemBoxes, itemBox.itemBoxes);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemBoxes);
    }
}