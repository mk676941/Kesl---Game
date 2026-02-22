package core;

import java.util.HashMap;
import java.util.Map;

public class NPC {
    private String id;
    private String name;
    private String dialogue;

    private String requiredItemId;
    private String rewardItemId;

    private Map<String, String> items;
    private Map<String, String> quests;

    public NPC(String id, String name, String dialogue) {
        this.id = id;
        this.name = name;
        this.dialogue = dialogue;

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

    //quests
    public boolean addQuest(String quest) {
        quests.put(quest, quest);
        return true;
    }
    public String getQuest(String questId) {
        return quests.get(questId);
    }
    public boolean hasQuest(String questId) {
        return quests.containsKey(questId);
    }

    //quest reward management
    public String getRewardItemId() {
        return rewardItemId;
    }
    public void setRewardItemId(String rewardItemId) {
        this.rewardItemId = rewardItemId;
    }

    //required item management
    public String getRequiredItemId() {
        return requiredItemId;
    }
    public void setRequiredItemId(String requiredItemId) {
        this.requiredItemId = requiredItemId;
    }

    //items management
    public boolean addItem(String item) {
        items.put(item, item);
        return true;
    }
    public Map<String, String> getItems() {
        return items;
    }

    public String removeItem(String itemId) {
        return items.remove(itemId);
    }
    public boolean hasItem(String itemId) {
        return items.containsKey(itemId);
    }
}
//TODO obstarat studenta na chodbe
