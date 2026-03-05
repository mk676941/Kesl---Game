package core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovaci trida pro CreateWorld.
 * Testuje navratove hodnoty metody startCommand.
 */
class GameTest {

    private Game game;

    @BeforeEach
    /**
     * Vytvori instanci tridy Game pred kazdym testem.
     */
    void setUp() {
        game = new Game();
    }

    @Test
    /**
     * Testuje zda startCommand vraci 0 kdyz uzivatel zada platny command.
     */
    void startValidCommand() {
        String[] commands = {"backpack", "go j", "explore", "help", "map", "put karta", "take klic"};
        game.getPlayer().addItem("karta");
        game.getWorld().getRoom("chodba").addItem("klic");

        for (String cmd : commands) {
            game.getPlayer().setCurrentRoom("chodba");
            int result = game.startCommand(cmd);
            assertEquals(0, result,  cmd + " Command by měl vracet 0.");
        }
    }

    @Test
    /**
     * Testuje zda startCommand vraci 9 kdyz uzivatel zada ExitCcommand.
     */
    void startExitCommand() {
        int result = game.startCommand("exit");
        game.endGame();
        assertEquals(9, result,  "Exit command by měl vracet 9.");
    }

    @Test
    /**
     * Testuje zda startCommand vraci 1 kdyz uzivatel zada neplatny command.
     */
    void startInvalidCommand() {
        int result = game.startCommand("neexistuje");
        assertEquals(1, result, "Neplatný command by měl vracet 1.");
    }

    @Test
    /**
     * Testuje zda startCommand vraci ruzne navratove hodnoty podle vstupu uzivatele pro GoCommand.
     */
    void startGoCommand() {
        int result;
        String[] commands = {"go j", "go", "go s", "go j"};

        //presun funguje
        game.getPlayer().setCurrentRoom("kmenovaucebna");
        result = game.startCommand(commands[0]);
        assertEquals(0, result,  commands[0] + " Command by měl vracet 0.");

        //nezadany smer
        game.getPlayer().setCurrentRoom("kmenovaucebna");
        result = game.startCommand(commands[1]);
        assertEquals(2, result,  commands[1] + " Command by měl vracet 2.");

        //mistnost nema exit v zadanem smeru
        game.getPlayer().setCurrentRoom("kmenovaucebna");
        result = game.startCommand(commands[2]);
        assertEquals(3, result,  commands[2] + " Command by měl vracet 3.");

        //presun do hlavniho vchodu
        game.getPlayer().setCurrentRoom("chodba");
        game.getPlayer().addItem("heslo");
        game.getPlayer().addItem("karta");
        result = game.startCommand(commands[3]);
        assertEquals(9, result,  commands[3] + " Command by měl vracet 9.");
    }

    @Test
    /**
     * Testuje zda startCommand vraci ruzne navratove hodnoty podle vstupu uzivatele pro TakeCommand.
     */
    void startTakeCommand() {
        int result;
        String[] commands = {"take", "take a", "take pacidlo"};
        game.getWorld().getRoom(game.getPlayer().getCurrentRoom()).addItem("pacidlo");

        //nezdany item
        result = game.startCommand(commands[0]);
        assertEquals(4, result, commands[0] + " Command by měl vracet 4.");

        //mistnost neni prozkoumana
        result = game.startCommand(commands[1]);
        assertEquals(0, result, commands[1] + " Command by měl vracet 0.");

        //item nebyl nalezen
        game.getWorld().getRoom(game.getPlayer().getCurrentRoom()).explore();
        result = game.startCommand(commands[1]);
        assertEquals(5, result, commands[1] + " Command by měl vracet 5.");

        //uspesne sebrani
        result = game.startCommand(commands[2]);
        assertEquals(0, result, commands[2] + " Command by měl vracet 0.");
    }

    @Test
    /**
     * Testuje zda startCommand vraci ruzne navratove hodnoty podle vstupu uzivatele pro PutCommand.
     */
    void startPutCommand() {
        int result;
        String[] commands = {"put", "put a", "put pacidlo"};
        game.getPlayer().addItem("pacidlo");

        //nezdany item
        result = game.startCommand(commands[0]);
        assertEquals(4, result, commands[0] + " Command by měl vracet 4.");

        //mistnost neni prozkoumana
        result = game.startCommand(commands[1]);
        assertEquals(0, result, commands[1] + " Command by měl vracet 0.");

        //item nebyl nalezen
        game.getWorld().getRoom(game.getPlayer().getCurrentRoom()).explore();
        result = game.startCommand(commands[1]);
        assertEquals(5, result, commands[1] + " Command by měl vracet 5.");

        //uspesne sebrani
        result = game.startCommand(commands[2]);
        assertEquals(0, result, commands[2] + " Command by měl vracet 0.");
    }

    @Test
    /**
     * Testuje zda startCommand vraci ruzne navratove hodnoty podle vstupu uzivatele pro TalkCommand.
     */
    void startTalkCommand() {
        int result;
        String[] commands = {"talk", "talk", "talk"};

        //mistnost neni prozkoumana
        result = game.startCommand(commands[0]);
        assertEquals(0, result, commands[0] + " Command by měl vracet 0.");

        //v mistnosti neni npc
        game.getWorld().getRoom(game.getPlayer().getCurrentRoom()).explore();
        result = game.startCommand(commands[1]);
        assertEquals(6, result, commands[1] + " Command by měl vracet 6.");

        //uspesna interakce
        game.getPlayer().setCurrentRoom("chodba");
        game.getWorld().getRoom(game.getPlayer().getCurrentRoom()).explore();
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        result = game.startCommand(commands[1]);
        assertEquals(0, result, commands[1] + " Command by měl vracet 0.");
    }

    @Test
    /**
     * Testuje zda registerCommands vyplni mapu commandu.
     */
    void registerCommands() {
        game.registerCommands();
        String[] expectedCommands = {"go", "take", "put", "talk", "explore", "backpack", "help", "exit", "map"};
        for (String cmd : expectedCommands) {
            assertTrue(game.getCommands().containsKey(cmd), "Mapa příkazů musí obsahovat: " + cmd);
        }
    }
}