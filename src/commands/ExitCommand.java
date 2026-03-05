package commands;

public class ExitCommand implements Command {

    public ExitCommand() {}

    /**
     * Ukonci hru
     * @param args - commandid
     * @return int
     */
    @Override
    public int execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return 9;
    }
}