package commands;
import core.*;

import java.util.Scanner;

public class TalkCommand implements Command {

    private Player player;
    private World world;

    public TalkCommand(Player player, World world) {
        this.player = player;
        this.world = world;
    }

    @Override
    public boolean execute(String[] args) {

        Room room = world.getRoom(player.getCurrentRoom());

        if (room.getNpcs().isEmpty()) {
            System.out.println("V: " + room.getName() + " není žádné NPC.");
        } else {
            String key = world.getNpcs().keySet().iterator().next();

            if (key == "studentnachodbe") {
                System.out.println(world.getNPC("studentnachodbe").getDialogue());
                System.out.println();

                Scanner sc = new Scanner(System.in);

                boolean interaction = true;

                while (interaction) {

                    System.out.println("Menu:");
                    System.out.println("---------------------------------------------------");
                    System.out.println("1. Inventář");
                    System.out.println("2. Požádat o pomoc");
                    System.out.println("3. Exit");
                    System.out.println();
                    System.out.print("Zadej číslo možnosti>");

                    int mainInput = sc.nextInt();
//TODO dopsat switche
                    switch (mainInput) {
                        case 1:
                            boolean invt = true;

                            while (invt) {
                                System.out.println("1. Dát item");
                                System.out.println("2. Vzít item");
                                System.out.println("3. Zpět");
                                int i = sc.nextInt();

                                switch (i) {
                                    case 1:
                                        if (world.getNPC(key).getItems().isEmpty()) {
                                            System.out.println("Inventář NPC je prázdný.");
                                        } else {
                                            System.out.println("Obsah inventáře NPC:");
                                            System.out.println("---------------------------------------------------");
                                            for (String itemId : world.getNPC(key).getItems().keySet()) {
                                                Item item = world.getItem(itemId);
                                                System.out.println(">>> " + item.getName());
                                            }
                                        }
                                }
                            }
                            break;
                        case 2:
                            if (!player.getHasHelp()) {
                                player.setHasHelp(true);
                                System.out.println("Dobrá, hned jdu odsunout tu skříň, která blokuje dílnu.");
                            } else {
                                System.out.println("Už jsem skříň odsunul.");
                            }
                            break;
                        case 3:
                            interaction = false;
                            break;
                        default:
                            interaction = true;
                            System.out.println("Neplatný vstup.");
                    }
                    break;
                }
            }

            if (key == "skolnik") {

            }
        }
        return true;
    }
    //TODO jak ziskat studenta z dane mistnosti
}