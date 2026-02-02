package core;

public class CreateWorld {
    private World world;

    public CreateWorld() {
        world = new World();
    }

    public void fillWorld () {
        world.addRoom(new Room("kmenovaucebna", "Kmenova ucebna", "Vychozi mistnost hrace"));
        world.addRoom(new Room("chodba", "Chodba", "Hlavni propojovaci prostor"));
        world.addRoom(new Room("laborka", "Laborka", "Tajuplna mistnost chemie"));
        world.addItem(new Item("pacidlo", "Pacidlo"));
        world.addNPC(new NPC("skolnik","Skolnik", "blablabla", "otevri dvere"));
        world.getRoom("laborka").setRequiredItemId("pacidlo");
    }
}
