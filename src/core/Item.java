package core;

public class Item {
    private String id;
    private String name;

    public Item(String id, String name){
        this.id = id;
        this.name = name;
    }

    //info
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
