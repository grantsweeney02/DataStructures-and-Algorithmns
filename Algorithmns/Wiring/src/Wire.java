public class Wire implements Comparable<Wire>{
    public Component source;
    public Component destination;
    public int cost;

    public Wire(Component source, Component destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return source.name + " " + destination.name +  " " + cost;
    }

    @Override
    public int compareTo(Wire o) {
        return Integer.compare(this.cost, o.cost);
    }

}
