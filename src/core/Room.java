package core;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private String id;
    private String name;
    private String description;

    private Map<String, Room> exits;

    private Map<String, Item> items;
    private Map<String, NPC> npcs;

    private boolean explored;

    private boolean blocked;
    private String requiredItemId;

    public Room(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

        this.exits = new HashMap<String, Room>();
        this.items = new HashMap<String, Item>();
        this.npcs = new HashMap<String, NPC>();

        this.explored = false;
        this.blocked = false;
    }

    //info
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    //exits management
    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    public Map<String, Room> getExits() {
        return exits;
    }

    //exploreing
    public void explore() {
        this.explored = true;
    }
    public boolean isExplored() {
        return explored;
    }

    //items management
    public boolean addItem(Item item) {
        items.put(item.getId(), item);
        return true;
    }
    public Item removeItem(String itemId) {
        return items.remove(itemId);
    }
    public boolean hasItem(String itemId) {
        return items.containsKey(itemId);
    }

    //npcs management
    public boolean addNpc(NPC npc) {
        npcs.put(npc.getId(), npc);
        return true;
    }
    public NPC getNpc(String npcId) {
        return npcs.get(npcId);
    }
    public boolean hasNpc(String npcId) {
        return npcs.containsKey(npcId);
    }

    //enter requiraments
    public boolean isBlocked() {
        return blocked;
    }
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getRequiredItemId() {
        return requiredItemId;
    }
    public void setRequiredItemId(String itemId) {
        requiredItemId = itemId;
    }
}
