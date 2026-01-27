package game.commands;
import game.core.Game;

public class HelpCommand implements Command {

    private Game game;

    public HelpCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}