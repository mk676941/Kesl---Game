package commands;
import core.Game;

public class ExitCommand implements Command {


    public ExitCommand() {}

    @Override
    public boolean execute(String[] args) {
        return false;
    }
}