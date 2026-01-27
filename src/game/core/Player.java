package game.core;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private Map<String, Item> inventory;
    private int capacity;

    public Player(int capacity) {
        this.capacity = capacity;
        this.inventory = new HashMap<String, Item>();
    }

    //TODO dopsat metody
    public boolean addItem(Item item) {}
    public Item removeItem(String itemId) {}
    public boolean hasItem(String itemId){}
    public boolean isInventoryFull(){}

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public int getCapacity() {
        return capacity;
    }
}
