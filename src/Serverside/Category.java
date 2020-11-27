package Serverside;

public enum Category {
    CULTURE("Kultur"),
    GAMING("Gaming"),
    MUSIC("Musik"),
    SPORTS("Sport");

    String name;

    Category(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return name;
    }
}
