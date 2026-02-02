package core;
import commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Map<String, Command> commands;
    private boolean running = true;

    public Game() {
        this.commands = new HashMap<>();
        Player player = new Player(3);

        registerCommands();
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

    public void StartCommand(String key) {
        String[] parts = key.split("\\s+");

        Command command = commands.get(parts[0]);

        if (command == null) {
            System.out.println("invalid input");
            return;
        }
        command.execute(parts);
    }

        public void run () {
        Scanner sc = new Scanner(System.in);

        while (running) {
            String input = sc.nextLine();
            StartCommand(input);
        }
    }

    public void endGame () {
        running = false;
    }
}