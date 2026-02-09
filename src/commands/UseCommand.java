package commands;
import core.Game;

public class UseCommand implements Command {

    private Game game;

    public UseCommand(Game game) {
        this.game = game;
    }

    @Override
    public boolean execute(String[] args) {
        return true;
    }
}
