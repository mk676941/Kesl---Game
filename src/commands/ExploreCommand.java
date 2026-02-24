package commands;
import core.*;

public class ExploreCommand implements Command {

    private World world;
    private Player player;

    public ExploreCommand(World world, Player player) {
        this.world = world;
        this.player = player;
    }

    /**
     * Prozkouma mistnost
     * Vypise NPC v mistnosti
     * Vypise itemy v mistnosti
     * Odemkne commandy talk, take, put
     * @param args - commandid
     * @return boolean
     */
    @Override
    public boolean execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        Room room = world.getRoom(player.getCurrentRoom());

        //prozkoumavani
        if (room.isExplored()) {
            System.out.println("Místnost: " + room.getName() + " je už prozkoumaná.");
            System.out.println();
        } else {
            room.explore();
            System.out.println("prozkoumal jsi: " + world.getRoom(player.getCurrentRoom()).getName());
            System.out.println();
        }

        //vypis npc
        if (room.hasNpc()) {
            System.out.println("V místnosti se nachází: ");
            System.out.println("---------------------------------------------------");
        }
        for (String npcId : room.getNpcs().keySet()) {
            NPC npc = world.getNPC(npcId);
            System.out.println(">>> " + npc.getName());
            System.out.println();
        }

        //vypis itemu
        if (room.hasItem()) {
            System.out.println("V místnosti je:");
            System.out.println("---------------------------------------------------");
            for (String itemId : room.getItems().keySet()) {
                Item item = world.getItem(itemId);
                System.out.printf(">>> item id: %-15s item name: %s%n",
                        itemId,
                        item.getName());
            }
        } else System.out.println("V místnosti není žádný item.");

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}