package commands;
import core.Game;

public class HelpCommand implements Command {

    private Game game;

    public HelpCommand(Game game) {
        this.game = game;
    }

    @Override
    public boolean execute(String[] args) {
        return true;
    }
}