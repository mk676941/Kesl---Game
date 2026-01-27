package cz.game.commands;
import cz.game.core.Game;

public class GoCommand implements Command {

    private Game game;

    public GoCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}
