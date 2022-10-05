public class Task {
    public enum Color {
        WHITE,
        BLACK,
        GRAY
    }
    public Task prev;
    public Color color;
    public int time;
    public String name;

    public Task(String name) {
        this.color = Color.WHITE;
        this.time = 0;
        this.prev = null;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
