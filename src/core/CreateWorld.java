package core;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateWorld {
    private World world;

    public CreateWorld() {
        world = new World();
    }

    //TODO dodelat questy
    //world fill
    public void fillWorld () {
        world.addRoom(new Room("kmenovaucebna", "Kmenova ucebna", "Vychozi mistnost hrace"));
        world.addRoom(new Room("chodba", "Chodba", "Hlavni propojovaci prostor"));
        world.addRoom(new Room("pocitacovaucebna", "Pocitacova ucebna", "beep-beep-beep"));
        world.addRoom(new Room("laborka", "Laborka", "Smradlava mistnost chemie"));
        world.addRoom(new Room("dilna", "Dilna", "Dilna plna harampadi"));
        world.addRoom(new Room("kabinet", "Kabinet", "Kabinet zle tridni"));
        world.addRoom(new Room("serverovaucebna", "Serverova ucebna", "Skolni serverovna"));
        world.addRoom(new Room("vratnice", "Vratnice", "Skolnikuv bejvak"));
        world.addRoom(new Room("hlavnivchod", "Hlavni vchod", "Unikova cesta"));

        world.addItem(new Item("pacidlo", "Pacidlo"));
        world.addItem(new Item("kyselina", "Kyselina sirova"));
        world.addItem(new Item("klicodkabinetu", "Klic od Kabinetu"));
        world.addItem(new Item("karta", "Karta hlavnich dveri"));
        world.addItem(new Item("kod", "3-ciselny kod"));
        world.addItem(new Item("heslo", "Heslo hlavnich dveri"));

        world.addNPC(new NPC("studentnachodbe", "Student na chodbe", "Ahoj, jak ti mohu pomoci?", " "));
        world.addNPC(new NPC("studentvpocitacoveucebne", "Student v pocitacove ucebne", "Ahoj. Jestli chces ziskat 3-ciselny kod, budes si ho muset zaslouzit.", " "));
        world.addNPC(new NPC("spravcedilny", "Spravce dilny", "Konecne nekdo odsunul tu skrin! Dekuji, chces pacidlo za odmenu?", " "));
        world.addNPC(new NPC("spravceserveroveucebny", "Spravce serverove ucebny", "Koukam ze jsi zjistil kod. Zvladnes dalsi ulohu za heslo?", " "));
        world.addNPC(new NPC("skolnik","Skolnik", "Arghh... Jestli chces klic tak mi prines neco z laborky", " "));

        world.getRoom("chodba").addNpc("studentnachodbe");
        world.getRoom("pocitacovaucebna").addNpc("studentvpocitacoveucebne");
        world.getRoom("dilna").addNpc("spravcedilny");
        world.getRoom("serverovaucebna").addNpc("spravceserveroveucebny");
        world.getRoom("vratnice").addNpc("skolnik");

        world.getRoom("pocitacovaucebna").addItem("kod");
        world.getRoom("laborka").addItem("kyselina");
        world.getRoom("dilna").addItem("pacidlo");
        world.getRoom("kabinet").addItem("karta");
        world.getRoom("serverovaucebna").addItem("heslo");
        world.getRoom("vratnice").addItem("klicodkabinetu");

        world.getRoom("kmenovaucebna").addExit("J", "chodba");
        world.getRoom("pocitacovaucebna").addExit("JZ","chodba");
        world.getRoom("laborka").addExit("Z", "chodba");
        world.getRoom("dilna").addExit("V", "chodba");
        world.getRoom("kabinet").addExit("JV", "chodba");
        world.getRoom("serverovaucebna").addExit("SZ", "chodba");
        world.getRoom("vratnice").addExit("SV", "chodba");
        world.getRoom("hlavnivchod").addExit("S","chodba");

        world.getRoom("chodba").addExit("S", "kmenovaucebna");
        world.getRoom("chodba").addExit("SV", "pocitacovaucebna");
        world.getRoom("chodba").addExit("V", "laborka");
        world.getRoom("chodba").addExit("Z", "dilna");
        world.getRoom("chodba").addExit("SZ", "kabinet");
        world.getRoom("chodba").addExit("JV", "serverovaucebna");
        world.getRoom("chodba").addExit("JZ", "vratnice");
        world.getRoom("chodba").addExit("J", "hlavnivchod");
    }

    //gson save
    public void saveWorld() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(world);
        try {
            Files.write(Paths.get("C:/Users/matej/Downloads/test.json"), json.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //gson load
    public void loadWorld() {
        Gson gson = new Gson();
        String json;

        try {
            json = Files.readString(Paths.get("C:/Users/matej/Downloads/test.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        world = gson.fromJson(json, World.class);
    }



}
