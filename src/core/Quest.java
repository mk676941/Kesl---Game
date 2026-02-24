package core;

import java.util.Map;

public class Quest {
    private String questId;
    private String questText;
    private String answer;
    private QuestState state = QuestState.NOT_STARTED;
    private Map<QuestState, String> hints;

    public Quest (String questId, String questText, String answer) {
        this.questId = questId;
        this.questText = questText;
        this.answer = answer;

        state = QuestState.NOT_STARTED;
    }

    //info
    public String getQuestId() {
        return questId;
    }
    public String getQuestText() {
        return questText;
    }
    public String getAnswer() {
        return answer;
    }

    //hints management (future addition)
    public void addHints (QuestState state, String hint) {
        hints.put(state, hint);
    }
    public String getHint (QuestState state) {
        return hints.get(state);
    }

    //quest state management (future addition)
    public QuestState getState() {
        return state;
    }
    public void setState(QuestState state) {
        this.state = state;
    }
}
