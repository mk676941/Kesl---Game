package commands;
import core.Game;
import core.Player;

public class BackpackCommand implements Command {

    private Game game;

    public BackpackCommand(Game game) {
        this.game = game;
    }

    @Override
    public boolean execute(String[] args) {
        return true;
    }
}
