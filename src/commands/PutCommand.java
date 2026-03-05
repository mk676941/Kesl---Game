package commands;
import core.Player;
import core.World;

/**
 * Command pro odlozeni itemu.
 * Obsahuje execute pro odlozeni itemu do mistnosti.
 * @author Matej Kesl
 */
public class PutCommand implements Command {

    private World world;
    private Player player;

    public PutCommand(World world, Player player) {
        this.world = world;
        this.player = player;
    }

    /**
     * Ulozi item z inventare hrace do inventare mistnosti.
     * @param args commandId, item
     * @return int
     */
    @Override
    public int execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        //kontrola delky pole
        if (args.length < 2) {
            System.out.println("Nezadal jsi item.");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            return 4;
        }

        //kontrola prozkoumani
        if (!world.getRoom(player.getCurrentRoom()).isExplored()) {
            System.out.println("Místnost není prozkoumaná.");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            return 0;
        }

        String itemId = args[1].toLowerCase();
        boolean item = player.hasItem(itemId);

        //kontrola vstupu
        if (!item) {
            System.out.println("Item nebyl nalezen.");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            return 5;
        } else {
            //ulozeni itemu do inventare mistnosti, odebrani itemu z inventare hrace
            world.getRoom(player.getCurrentRoom()).addItem(itemId);
            player.removeItem(itemId);
            System.out.println("Item byl uložen do místnosti.");
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return 0;
    }
}
