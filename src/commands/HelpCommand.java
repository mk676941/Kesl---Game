package commands;
import core.Game;
import core.Item;
import core.Player;
import core.World;

public class HelpCommand implements Command {

    private Game game;
    private World world;

    public HelpCommand(Game game, World world) {
        this.game = game;
        this.world = world;
    }

    @Override
    public boolean execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("Aby jsi úspěšně unikl z Ječné, potřebuješ odemknout hlavní vchod pomocí:\n>>> Kartou hlavních dveří\n>>> Heslem hlavních dveří");
        System.out.println();
        System.out.println("Některé místnosti jsou nepřístupné. Ke vstupu potřebuješ buď nějaký item, nebo pomoc některého z NPC.");
        System.out.println();
        System.out.println("Seznam všech commandů. Voláš je pomocí command id:");
        System.out.println("-------------------------------");
        for (String commandId : game.getCommands().keySet()) {
            System.out.println(">>> command id: " + commandId);
        }
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("Seznam všech itemů. Pracuješ s nima pomocí item id:");
        System.out.println("-------------------------------");
        for (String itemId : world.getItems().keySet()) {
            Item item = world.getItems().get(itemId);
            System.out.printf(">>> item id: %-15s item name: %s%n",
                    itemId,
                    item.getName());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}