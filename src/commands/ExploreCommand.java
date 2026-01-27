package commands;
import core.Game;

public class ExploreCommand implements Command {

    private Game game;

    public ExploreCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}