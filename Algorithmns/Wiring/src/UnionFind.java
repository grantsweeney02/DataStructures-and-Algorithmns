import java.util.HashMap;

public class UnionFind {
    private int[] array;
    private int currNode;
    HashMap<Component, Integer> mappy = new HashMap<>();
    public UnionFind(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }
    public boolean connected(Wire wire) {
        Component source = wire.source;
        Component destination = wire.destination;
        if(!mappy.containsKey(source)) {
            mappy.put(source, currNode);
            currNode++;
        }
        if(!mappy.containsKey(destination)) {
            mappy.put(destination, currNode);
            currNode++;
        }
        int sourceParentIndex = mappy.get(source);
        int destinationParentIndex = mappy.get(destination);
        int sourceParent = array[sourceParentIndex];
        int destinationParent = array[destinationParentIndex];
//        System.out.println(sourceParent + " " + destinationParent);
        return sourceParent == destinationParent;
    }
    public void union(Wire wire) {
        Component source = wire.source;
        Component destination = wire.destination;
        int sourceParentIndex = mappy.get(source);
        int destinationParentIndex = mappy.get(destination);
        if(array[destinationParentIndex] < array[sourceParentIndex]) {
            array[sourceParentIndex] = array[destinationParentIndex];
        } else {
            array[destinationParentIndex] = array[sourceParentIndex];
        }


//        connected(wire);
    }
}
