package game.core;

import java.util.HashMap;
import java.util.Map;

public class NPC {
    private String id;
    private String name;
    private String dialogue;

    private QuestState state;
    private Map<QuestState, String> hints;

    private String requiredItemId;
    private String rewardItemId;

    private Map<String, Item> items;

    public NPC(String id, String name, String dialogue) {
        this.id = id;
        this.name = name;
        this.dialogue = dialogue;
        this.state = QuestState.NOT_STARTED;
        this.hints = new HashMap<QuestState, String>();
        this.items = new HashMap<String, Item>();
    }



    public String getId() {
        return id;
    }

    public String getDialogue() {
        return dialogue;
    }

    public String getName() {
        return name;
    }



    public QuestState getState() {
        return state;
    }

    public void setState(QuestState state) {
        this.state = state;
    }



    public String getRewardItemId() {
        return rewardItemId;
    }

    public void setRewardItemId(String rewardItemId) {
        this.rewardItemId = rewardItemId;
    }



    public String getRequiredItemId() {
        return requiredItemId;
    }

    public void setRequiredItemId(String requiredItemId) {
        this.requiredItemId = requiredItemId;
    }



    public String getHint() {} //TODO vybrat konktretni hint z mapy

    public void addHint(QuestState state, String hint) {} //TODO pridat hint do mapy



//TODO dopsat metody
    public boolean addItem(Item item) {}
    public Item removeItem(String itemId) {}
    public boolean hasItem(String itemId) {}
}
