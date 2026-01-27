package game.commands;
import game.core.Game;

public class BackpackCommand implements Command {

    private Game game;

    public BackpackCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}
