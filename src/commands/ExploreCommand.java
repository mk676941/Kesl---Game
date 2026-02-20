package commands;
import core.*;

import java.util.Random;

public class ExploreCommand implements Command {

    private World world;
    private Player player;

    public ExploreCommand(World world, Player player) {
        this.world = world;
        this.player = player;
    }

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
        if (room.hasNpc())
            System.out.print("V místnosti se nachází: ");
        for (String npcId : room.getNpcs().keySet()) {
            NPC npc = world.getNPC(npcId);
            System.out.println(npc.getName());
            System.out.println();
        }

        //vypis itemu v mistnosti
        if (room.hasItem()) {
            System.out.println("V místnosti je:");
            for (String itemId : room.getItems().keySet()) {
                Item item = world.getItem(itemId);
                    System.out.println("- " + item.getName());
            }
        } else System.out.println("V místnosti není žádný item.");

        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}