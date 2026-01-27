package game.commands;
import game.core.Game;

public class ExitCommand implements Command {

    private Game game;

    public ExitCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}