package cz.game.commands;
import cz.game.core.Game;

public class UseCommand implements Command {

    private Game game;

    public UseCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}
