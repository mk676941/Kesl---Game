package core;

import java.util.HashMap;
import java.util.Map;

public class World {
    private Map<String, Room> rooms;
    private Room startRoom;

    public World() {
        this.rooms = new HashMap<>();
    }

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
}
