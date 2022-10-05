public class Component {
    public String name;
    public String type;

    public Component(String name, String type) {
        this.name = name;
        this.type = type;
    }
    @Override
    public String toString() {
        return name + " " + type;
    }
}
