package commands;
import core.Player;
import core.World;

public class TakeCommand implements Command {

    private World world;
    private Player player;

    public TakeCommand(World world, Player player) {
        this.world = world;
        this.player = player;
    }

    /**
     * Ulozi item z inventare mistnosti do inventare hrace
     * @param args - commandid, item
     * @return boolean
     */
    @Override
    public boolean execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        //kontrola delky pole
        if (args.length < 2) {
            System.out.println("Nezadal jsi item.");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            return true;
        }

        //kontrola prozkoumani
        if (!world.getRoom(player.getCurrentRoom()).isExplored()) {
            System.out.println("Místnost není prozkoumaná.");
            return true;
        }

        String itemId = args[1].toLowerCase();
        String item = world.getRoom(player.getCurrentRoom()).getItem(itemId);

        //kontrola vstupu
        if (item == null) {
            System.out.println("Item nebyl nalezen.");
        } else {
            //kontrola kapacity inventare
            if (player.isInventoryFull()) {
                System.out.println("Máš plný intentář. Odlož si u nekterého z NPC nejaký item z tvého intentáře.");
            } else {
                //ulozeni itemu do inventare hrace, odebrani itemu z inventare mistnosti
                world.getRoom(player.getCurrentRoom()).removeItem(item);
                player.addItem(item);
                System.out.println("Item byl přidán do tvého inventáře.");
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}
