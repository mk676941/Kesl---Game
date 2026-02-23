package commands;
import core.Player;
import core.World;

public class PutCommand implements Command {

    private World world;
    private Player player;

    public PutCommand(World world, Player player) {
        this.world = world;
        this.player = player;
    }

    @Override
    public boolean execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        //kontrola delky pole
        if (args.length < 2) {
            System.out.println("Nezadal jsi item.");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            return true;
        }

        if (!world.getRoom(player.getCurrentRoom()).isExplored()) {
            System.out.println("Místnost není prozkoumaná.");
            return true;
        }

        String itemId = args[1].toLowerCase();

        boolean item = player.hasItem(itemId);

        if (item == false) {
            System.out.println("Item nebyl nalezen.");
        } else {
            world.getRoom(player.getCurrentRoom()).addItem(itemId);
            player.removeItem(itemId);
            System.out.println("Item byl uložen do místnosti.");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}
