public class Player {
    private String name;
    private char mark;

    public Player(String name, Character mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public Character getMark() {
        return mark;
    }

//    @Override
//    public String toString() {
//        return "Player{" +
//                "name='" + name + '\'' +
//                ", mark=" + mark +
//                '}';
//    }
}
