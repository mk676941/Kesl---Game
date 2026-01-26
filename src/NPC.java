import java.util.Map;

public class NPC {
    private String id;
    private String name;
    private String dialogue;

    private QuestState state;
    private Map<QuestState, String> hints;


}
