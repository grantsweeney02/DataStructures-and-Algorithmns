import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numWord = scan.nextLine().split(" ");
        int numOfComponents = Integer.parseInt(numWord[0]);
        int numOfWires = Integer.parseInt(numWord[1]);
        ArrayList<Component> componentArray = new ArrayList<>();
        HashMap<Component, List<Component>> switchMap = new HashMap<>();
        ArrayList<Wire> wireArrayListForLights = new ArrayList<>();
        ArrayList<Wire> wireArrayList = new ArrayList<>();
        Component currSwitch = null;
        for (int i = 0; i < numOfComponents; i++) {
            String[] JPWord = scan.nextLine().split(" ");
            Component component = new Component(JPWord[0], JPWord[1]);
            if(JPWord[1].equals("switch")) {
                currSwitch = component;
                switchMap.put(component,new ArrayList<>());

            } else if(JPWord[1].equals("light")) {
                switchMap.get(currSwitch).add(component);
            }
            componentArray.add(component);
        }

        for (int i = 0; i < numOfWires; i++) {
            String[] wireWord = scan.nextLine().split(" ");
            String sourceName = wireWord[0];
            String destinationName = wireWord[1];
            Component source = null;
            Component destination = null;
            int cost = Integer.parseInt(wireWord[2]);
            for (Component component: componentArray) {
                if(component.name.equals(sourceName)) {
                    source = component;
                }
                if(component.name.equals(destinationName)) {
                    destination = component;
                }
            }
            if(source != null && destination != null) {
                wireArrayList.add(new Wire(source, destination, cost));
                wireArrayList.add(new Wire(destination, source, cost));
            }
        }
        ArrayList<Wire> componentWireArray = sortOutWireArray(wireArrayList, wireArrayListForLights);
        long totalCost = kruskals(componentWireArray, wireArrayListForLights, switchMap);
        System.out.println(totalCost);

    }

    public static long kruskals(ArrayList<Wire> componentWireArray, ArrayList<Wire> lightWireArray, HashMap<Component,List<Component>> switchMap) {
        long totalCost = 0;
        PriorityQueue<Wire> queue = new PriorityQueue<>(componentWireArray);
        UnionFind unionFind = new UnionFind(componentWireArray.size() + lightWireArray.size());
        while(!queue.isEmpty()) {
            Wire wire = queue.poll();
//            System.out.println(wire);
            if(unionFind.connected(wire)) {
                continue;
            }
            unionFind.union(wire);
            totalCost += wire.cost;
        }
        queue = new PriorityQueue<>(lightWireArray);
        while(!queue.isEmpty()) {
            Wire wire = queue.poll();
//            System.out.println(wire+"----------"+totalCost);
            if(unionFind.connected(wire)) {
                continue;
            }
            if(wire.source.type.equals("light") && wire.destination.type.equals("light")) {
                for (Component switchy: switchMap.keySet()) {
                    if(switchMap.get(switchy).contains(wire.source) && switchMap.get(switchy).contains(wire.destination)) {
                        unionFind.union(wire);
                        totalCost += wire.cost;
                    }
                }
            } else if (wire.source.type.equals("switch") && wire.destination.type.equals("light")) {
                if(switchMap.get(wire.source).contains(wire.destination)) {
                    unionFind.union(wire);
                    totalCost += wire.cost;
                }
            } else if (wire.source.type.equals("switch") && wire.destination.type.equals("switch")){
                continue;
            } else if(!(wire.destination.type.equals("light") || wire.source.type.equals("light"))) {
                unionFind.union(wire);
                totalCost += wire.cost;
            }
        }
        return totalCost;
    }
    public static ArrayList<Wire> sortOutWireArray(ArrayList<Wire> wireArrayList, ArrayList<Wire> wireArrayListForLights) {
        ArrayList<Wire> wireArrayListCopy = new ArrayList<>(wireArrayList);
        for (Wire wire: wireArrayList) {
            if(wire.destination.type.equals("switch") || wire.destination.type.equals("light") || wire.source.type.equals("switch") || wire.source.type.equals("light")) {
                wireArrayListCopy.remove(wire);
                wireArrayListForLights.add(wire);
            }
        }
        return wireArrayListCopy;
    }
}