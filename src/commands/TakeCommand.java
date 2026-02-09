package commands;
import core.Game;

public class TakeCommand implements Command {

    private Game game;

    public TakeCommand(Game game) {
        this.game = game;
    }

    @Override
    public boolean execute(String[] args) {
        return true;
    }
}
