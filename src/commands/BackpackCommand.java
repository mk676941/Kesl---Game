package commands;
import core.Game;
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

    @Override
    public boolean execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        if (player.getCapacity()==0){
            System.out.println("Batoh je prázdný.");
        } else {
            System.out.println("Obsah tvého batohu:");
            System.out.println("-------------------------------");
            for (String itemId : player.getInventory().keySet()) {
                Item item = world.getItem(itemId);
                System.out.println(">>> " + item.getName());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}
