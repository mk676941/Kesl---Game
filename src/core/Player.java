package core;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private Map<String, String> inventory;
    private int capacity;
    private String currentRoom;
    private boolean hasHelp;
    private boolean hasWon;

    public Player(int capacity) {
        this.capacity = capacity;
        this.inventory = new HashMap<String, String>();
        this.currentRoom = "kmenovaucebna";
        this.hasHelp = false;
        this.hasWon = false;
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

    //current room management
    public String getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    //help management
    public boolean getHasHelp() {
        return hasHelp;
    }
    public void setHasHelp(boolean hasHelp) {
        this.hasHelp = hasHelp;
    }

    //win management
    public boolean getHasWon() {
        return hasWon;
    }
    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }
}