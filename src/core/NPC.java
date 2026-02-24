package core;

import java.util.HashMap;
import java.util.Map;

public class NPC {
    private String id;
    private String name;
    private String dialogue;

    private String requiredItemId;
    private boolean canHelp;

    private Map<String, String> items;
    private Map<String, String> quests;

    public NPC(String id, String name, String dialogue) {
        this.id = id;
        this.name = name;
        this.dialogue = dialogue;
        this.requiredItemId = null;
        this.canHelp = false;

        this.items = new HashMap<String, String>();
        this.quests = new HashMap<String, String>();
    }


    //info
    public String getId() {
        return id;
    }
    public String getDialogue() {
        return dialogue;
    }
    public String getName() {
        return name;
    }

    //quests management
    public boolean addQuest(String quest) {
        quests.put(quest, quest);
        return true;
    }
    public Map<String, String> getQuests() {
        return quests;
    }

    //required item management
    public String getRequiredItemId() {
        return requiredItemId;
    }
    public void setRequiredItemId(String requiredItemId) {
        this.requiredItemId = requiredItemId;
    }

    //help management
    public boolean getCanHelp() {
        return canHelp;
    }
    public void setCanHelp(boolean canHelp) {
        this.canHelp = canHelp;
    }

    //items management
    public boolean addItem(String item) {
        items.put(item, item);
        return true;
    }
    public Map<String, String> getItems() {
        return items;
    }
}
