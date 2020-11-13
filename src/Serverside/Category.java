package Serverside;

public enum Category {
    SPORTS("Sport"),
    GAMING("Gaming"),
    MUSIC("Musik"),
    CULTURE("Kultur");

    String name;

    Category(String name){
        this.name = name;
    }

    public String getCategoryName(){
        return name;
    }
}
