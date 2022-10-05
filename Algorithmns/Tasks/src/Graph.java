import java.util.*;

public class Graph {
    private HashMap<Task, LinkedList<Task>> map;
    private ArrayList<Task> topoSortList = new ArrayList<>();
    private int time;

    public Graph(HashMap<Task, LinkedList<Task>> map) {
        this.map = map;
    }
    public void topoSort() {
        time = 0;
        for(Task task: map.keySet()) {
            if(task.color == Task.Color.WHITE) {
                topoSortVisit(task);
            }
        }
        printTopo();
    }
    public void topoSortVisit(Task task) {
        time += 1;
        task.time = time;
        task.color = Task.Color.GRAY;
        LinkedList<Task> listy = map.get(task);
        for(Task tasky: listy) {
            if(tasky.color == Task.Color.WHITE) {
                topoSortVisit(tasky);
            }
        }
        task.color = Task.Color.BLACK;
        time += 1;
        topoSortList.add(task);
    }
    public void printTopo() {
        Stack<Task> stack = new Stack<>();
        for (Task task: topoSortList) {
            stack.push(task);
        }
        for (int i = 0; i < topoSortList.size(); i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
