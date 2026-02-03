package core;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private Map<String, String> inventory;
    private int capacity;

    public Player(int capacity) {
        this.capacity = capacity;
        this.inventory = new HashMap<String, String>();
    }

    //items management
    public boolean addItem(String item) {
        if (isInventoryFull()) {
            return false;
        } else {
            inventory.put(item, item);
        }
        return true;
    }
    public String removeItem(String itemId) {
        return inventory.remove(itemId);
    }
    public boolean hasItem(String itemId){
        return inventory.containsKey(itemId);
    }

    //inventory
    public boolean isInventoryFull(){
        return inventory.size() == capacity;
    }
    public Map<String, String> getInventory() {
        return inventory;
    }
    public int getCapacity() {
        return capacity;
    }
}
//TODO zmenit mapy na String nebo ArrayList
