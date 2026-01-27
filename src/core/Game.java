package core;
import commands.*;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Command> commands;

    public Game() {
        this.commands = new HashMap<>();
    }

    public void registerCommands() {
        commands.put("go", new GoCommand(this));
        commands.put("use", new UseCommand(this));
        commands.put("take", new TakeCommand(this));
        commands.put("talk", new TalkCommand(this));
        commands.put("explore", new ExploreCommand(this));
        commands.put("backpack", new BackpackCommand(this));
        commands.put("help", new HelpCommand(this));
        commands.put("exit", new ExitCommand(this));
    }

    public void StartCommands(String key) {
        String[] parts = key.split(" ");

        Command command = commands.get(parts[0]);

        if (command == null) {
            System.out.println("invlaid input");
            return;
        }
        command.execute(parts);
    }
}
