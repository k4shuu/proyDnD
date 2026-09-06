package model;

import items.Item;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }

    public int getTotalWeight() {
        return items.stream().mapToInt(Item::getWeight).sum();
    }

}
