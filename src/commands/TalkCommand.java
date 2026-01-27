package commands;
import core.Game;

public class TalkCommand implements Command {

    private Game game;

    public TalkCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}