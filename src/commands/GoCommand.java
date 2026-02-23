package commands;
import core.Item;
import core.Player;
import core.World;

public class GoCommand implements Command {

    private Player player;
    private World world;

    public GoCommand(Player player, World world) {
        this.player = player;
        this.world = world;
    }

    @Override
    public boolean execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        boolean help;
        boolean item;

        //kontrola delky pole
        if (args.length <2) {
            System.out.println("Nezadal jsi směr.");
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            return true;
        }

        String direction = args[1].toUpperCase();

        String exit = world.getRoom(player.getCurrentRoom()).getExit(direction);

        if (exit == null) {
            System.out.println("Tímto směrem není žádná cesta.");
        } else {

            //hlavni vchod
            if (exit=="hlavnivchod") {
                if (player.hasItem("karta")&&player.hasItem("heslo")) {
                    player.setHasWon(true);
                    return false;
                } else {
                    String itemId1 = "karta";
                    String itemId2 = "heslo";

                    Item item1 = world.getItem(itemId1);
                    Item item2 = world.getItem(itemId2);

                    System.out.println("Nemáš potřebné věci k úniku, potřebuješ:");
                    System.out.println("---------------------------------------------------");
                    System.out.printf(">>> item id: %-15s item name: %s%n",
                            itemId1,
                            item1.getName());
                    System.out.printf(">>> item id: %-15s item name: %s%n",
                            itemId2,
                            item2.getName());
                    System.out.println();
                }
            }

            //ostatni mistnosti
            if (world.getRoom(exit).isBlocked()) {

                //zablokovana mistnost
                if (world.getRoom(exit).isRequiredHelp()) {
                    if (player.getHasHelp()) {
                        help = true;
                    } else help = false;
                } else help = true;

                if (world.getRoom(exit).getRequiredItemId()!=null) {
                    if (player.getInventory().containsKey(world.getRoom(exit).getRequiredItemId())) {
                       item = true;
                    } else item = false;
                } else item = true;

                if (help && item) {
                    world.getRoom(exit).setBlocked(false, null, false);
                    player.setCurrentRoom(exit);
                    System.out.println("Přesunul jsi se do: " + world.getRoom(exit).getName());
                } else {
                    System.out.println("Do místnosti " + world.getRoom(exit).getName() + " se nemůžeš dostat. Potřebuješ:");
                    System.out.println("---------------------------------------------------");
                    String requiredItemId = world.getRoom(exit).getRequiredItemId();

                    if (requiredItemId != null) {
                        Item reqitem = world.getItem(requiredItemId);

                        System.out.printf(">>> item id: %-15s item name: %s%n",
                                requiredItemId,
                                reqitem.getName());
                    }
                    if (world.getRoom(exit).isRequiredHelp()) {
                        System.out.println("Pomoc s odsunutím skříně od některého NPC.");
                    }
                }
            } else {

                //odblokovana mistnost
                player.setCurrentRoom(exit);
                System.out.println("Přesunul jsi se do: " + world.getRoom(exit).getName());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return true;
    }
}
