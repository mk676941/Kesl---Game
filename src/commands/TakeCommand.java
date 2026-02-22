package commands;
import core.Game;
import core.Player;
import core.World;
import java.text.Normalizer;

public class TakeCommand implements Command {

    private World world;
    private Player player;

    public TakeCommand(World world, Player player) {
        this.world = world;
        this.player = player;
    }

    public static String normalize(String text) {
        return Normalizer
                .normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "") // odstraní diakritiku
                .toLowerCase()
                .trim();
    }

    @Override
    public boolean execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        if (!world.getRoom(player.getCurrentRoom()).isExplored()) {
            System.out.println("Místnost není prozkoumaná.");
        } else {
            //kontrola delky pole
            if (args.length < 2) {
                System.out.println("Nezadal jsi item.");
                return true;
            }

            String itemId = args[1].toLowerCase();

            String item = world.getRoom(player.getCurrentRoom()).getItem(itemId);

            if (item == null) {
                System.out.println("Item nebyl nalezen.");
            } else {

                if (!world.getRoom(player.getCurrentRoom()).isExplored()) {
                    System.out.println("Místnost není prozkoumaná.");
                } else {

                    //kontrola kapacity inventare
                    if (player.isInventoryFull()) {
                        System.out.println("Máš plný intentář. Odlož si u nekterého z NPC nejaký item z tvého intentáře.");
                    } else {
                        world.getRoom(player.getCurrentRoom()).removeItem(item);
                        player.addItem(item);
                        System.out.println("Item byl přidán do tvého inventáře.");
                    }
                }
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}
