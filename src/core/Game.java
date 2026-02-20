package core;
import commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Map<String, Command> commands;
    private Player player;
    private World world;
    private CreateWorld createWorld;

    public Game() {
        this.commands = new HashMap<>();
        this.player = new Player(3);
        this.world = new World();
        this.createWorld = new CreateWorld(world);
        createWorld.fillWorld();
        registerCommands();
    }

    public void registerCommands() {
        commands.put("go", new GoCommand(this.player, this.world));
        commands.put("use", new UseCommand(this));
        commands.put("take", new TakeCommand(this));
        commands.put("talk", new TalkCommand(this.player, this.world));
        commands.put("explore", new ExploreCommand(this.world, this.player));
        commands.put("backpack", new BackpackCommand(this));
        commands.put("help", new HelpCommand(this));
        commands.put("exit", new ExitCommand());
        commands.put("map", new MapCommand());
    }

    public boolean StartCommand(String key) {
        String[] parts = key.split("\\s+");

        Command command = commands.get(parts[0]);

        if (command == null) {
            System.out.println("Neplatný příkaz");
            return true;
        }
        return command.execute(parts);
    }

    public void run () {
        boolean running = true;

        Scanner sc = new Scanner(System.in);

        while (running) {
            String input = sc.nextLine();
            running = StartCommand(input);
        }
        endGame();
    }

    public void endGame () {
        if (player.getHasWon()){
            System.out.println("Gratuluji, vyhrál jsi!");
        } else System.out.println("Hodně štěstí příště.");
        System.out.println("Konec hry.");
    }
}