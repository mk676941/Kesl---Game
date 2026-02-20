package commands;
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
                    System.out.println("Nemáš potřebné věci k úniku, potřebuješ: " + world.getItem("karta").getName() + "; " + world.getItem("heslo").getName());
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
                    if (world.getRoom(exit).getRequiredItemId()!=null) {
                        System.out.println(world.getItem(world.getRoom(exit).getRequiredItemId()).getName());
                    }
                    if (world.getRoom(exit).isRequiredHelp()) {
                        System.out.println("pomoc od některého NPC");
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
