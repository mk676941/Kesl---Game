package commands;
import core.Game;
import core.Player;
import core.World;

public class TalkCommand implements Command {

    private Player player;
    private World world;

    public TalkCommand(Player player, World world) {
        this.player = player;
        this.world = world;
    }

    @Override
    public boolean execute(String[] args) {
        String npc = world.getRoom(player.getCurrentRoom()).getNpc("studentnachodbe");

        if (world.getRoom(player.getCurrentRoom()).hasNpc()) {
            System.out.println(world.getNPC(npc).getName() + ": " + world.getNPC(npc).getDialogue());
        } else {
            System.out.println("V této místnosti není žádné NPC.");
            return false;
        }
        return true;
    }
    //TODO jak ziskat studenta z dane mistnosti
}