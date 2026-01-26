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
    private String requiredFlagId; //TODO v Game je potreba ulozit stav flag

    private String taskId;

    public Room(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.exits = new HashMap<String, Room>();
        this.items = new HashMap<String, Item>();
        this.npcs = new HashMap<String, NPC>();
        this.explored = false;
        this.blocked = false;
        this.requiredItemId = null;
        this.requiredFlagId = null;
        this.taskId = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //TODO dopsat metody
    public void addExit(String key, Room room) {}
    public Room getExit(String key) {}

    public boolean isExplored() {}
    public void explore() {}

    public boolean addItem(Item item) {}
    public Item removeItem(String itemId) {}
    public boolean hasItem(String itemId) {}

    public boolean addNpc(NPC npc) {}
    public NPC getNpc(String npcId) {}
    public boolean hasNpc(String npcId) {}

    public boolean isBlocked() {}
    public void setBlocked(boolean blocked) {}

    public String getRequiredItemId() {}
    public void setRequiredItemId(String itemId) {}

    public String getRequiredFlagId() {}
    public void setRequiredFlagId(String flagId) {}

    public String getTaskId() {}
    public void setTaskId(String taskId) {}
}
