package commands;

/**
 * Interface Command pro Command pattern.
 * Obsahuje execute ktery dale definuji implementujici tridy.
 * @author Matej Kesl
 */
public interface Command {
    int execute(String[] args);
}
