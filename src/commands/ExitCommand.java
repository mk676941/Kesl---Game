package commands;

/**
 * Command pro ukonceni hry.
 * Obsahuje execute ktery ukonci main loop.
 * @author Matej Kesl
 */
public class ExitCommand implements Command {

    public ExitCommand() {}

    /**
     * Ukonci hru vracenim konkretniho cisla.
     * @param args commandId
     * @return int
     */
    @Override
    public int execute(String[] args) {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return 9;
    }
}