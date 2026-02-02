package core;

import java.util.HashMap;
import java.util.Map;

public class NPC {
    private String id;
    private String name;
    private String dialogue;
    private String quest;

    private QuestState state;
    private Map<QuestState, String> hints;

    private String requiredItemId;
    private String rewardItemId;

    private Map<String, Item> items;

    public NPC(String id, String name, String dialogue, String quest) {
        this.id = id;
        this.name = name;
        this.dialogue = dialogue;
        this.quest = quest;

        this.state = QuestState.NOT_STARTED;

        this.hints = new HashMap<QuestState, String>();
        this.items = new HashMap<String, Item>();
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
    public String getQuest() {
        return quest;
    }
    public boolean hasQuest() {
        return quest != null;
    }

    //quest state management
    public QuestState getState() {
        return state;
    }
    public void setState(QuestState state) {
        this.state = state;
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


    //hints management
    public String getHint() {
        return hints.get(state);
    }
    public void addHint(QuestState state, String hint) {
        hints.put(state, hint);
    }

    //items management
    public boolean addItem(Item item) {
        items.put(item.getId(), item);
        return true;
    }
    public Item removeItem(String itemId) {
        return items.remove(itemId);
    }
    public boolean hasItem(String itemId) {
        return items.containsKey(itemId);
    }
}
