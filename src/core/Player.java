package core;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private Map<String, Item> inventory;
    private int capacity;

    public Player(int capacity) {
        this.capacity = capacity;
        this.inventory = new HashMap<String, Item>();
    }

    //items management
    public boolean addItem(Item item) {
        if (isInventoryFull()) {
            return false;
        } else {
            inventory.put(item.getId(), item);
        }
        return true;
    }
    public Item removeItem(String itemId) {
        return inventory.remove(itemId);
    }
    public boolean hasItem(String itemId){
        return inventory.containsKey(itemId);
    }

    //inventory
    public boolean isInventoryFull(){
        return inventory.size() == capacity;
    }
    public Map<String, Item> getInventory() {
        return inventory;
    }
    public int getCapacity() {
        return capacity;
    }
}
