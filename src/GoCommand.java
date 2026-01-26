public class GoCommand implements Command{

    private Game game;

    public GoCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute(String[] args) {

    }
}
