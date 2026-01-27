package cz.game.commands;
import cz.game.core.Game;

public class TakeCommand implements Command {

    private Game game;

    public TakeCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}
