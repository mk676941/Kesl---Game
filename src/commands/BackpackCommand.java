package commands;
import core.Item;
import core.Player;
import core.World;

public class BackpackCommand implements Command {

    private Player player;
    private World world;

    public BackpackCommand(Player player, World world) {
        this.player = player;
        this.world = world;
    }

    /**
     * Vypise inventar hrace
     * @param args - commandid
     * @return boolean
     */
    @Override
    public boolean execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        //prazdny inventar
        if (player.getCapacity()==0){
            System.out.println("Batoh je prázdný.");
        } else {
            //vypis inventare
            System.out.println("Obsah tvého batohu:");
            System.out.println("---------------------------------------------------");
            for (String itemId : player.getInventory().keySet()) {
                Item item = world.getItem(itemId);
                System.out.printf(">>> item id: %-15s item name: %s%n",
                        itemId,
                        item.getName());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}
