package core;

import java.util.HashMap;
import java.util.Map;

public class World {
    private Map<String, Room> rooms;
    private Map<String, Item> items;
    private Map<String, NPC> npcs;
    private Map<String, Quest> quests;
    private Room startRoom;

    public World() {
        this.rooms = new HashMap<>();
        this.items = new HashMap<>();
        this.npcs = new HashMap<>();
        this.quests = new HashMap<>();
    }

    //rooms management
    public void addRoom(Room room) {
        rooms.put(room.getId(), room);
    }
    public Room getRoom(String id) {
        return rooms.get(id);
    }
    public Map<String, Room> getRooms() {
        return rooms;
    }
    public void setStartRoom(Room room) {
        this.startRoom = room;
    }
    public Room getStartRoom() {
        return startRoom;
    }

    //items management
    public void addItem(Item item) {
        items.put(item.getId(), item);
    }
    public Item getItem(String id) {
        return items.get(id);
    }

    //npc management
    public void addNPC(NPC npc) {
        npcs.put(npc.getId(), npc);
    }
    public NPC getNPC(String id) {
        return npcs.get(id);
    }

    //quests management
    public void addQest (Quest quest) {
        quests.put(quest.getQuestId(), quest);
    }
    public Quest getQuest (String id) {
        return quests.get(id);
    }
}
