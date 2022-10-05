import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("Please input the number of tasks and dependencies: ");
        String numbers = scan.nextLine();
        String[] nums = numbers.split(" ");
        int numOfTasks = Integer.parseInt(nums[0]);
        int numOfDependencies = Integer.parseInt(nums[1]);
        if (numOfTasks <= 0) {
            System.out.println("Impossible");
            System.exit(0);
        }
        ArrayList<Task> listOfTasks = new ArrayList<>();
        HashMap<Task, LinkedList<Task>> mappyWithLinky = new HashMap<>();
        for (int i = 0; i < numOfTasks; i++) {
//            System.out.println("Type a Task");
            Task task = new Task(scan.nextLine());
            listOfTasks.add(task);
        }
        for (int i = 0; i < numOfDependencies; i++) {
//            System.out.println("Type a dependency");
            String[] dependency = scan.nextLine().split(" ");
            String task1 = dependency[0];
            String task2 = dependency[1];
            Task temp1 = null;
            Task temp2 = null;
            for(Task task: listOfTasks) {
                if (task.name.equals(task1)) {
                    temp1 = task;
                }
                else if(task.name.equals(task2)) {
                    temp2 = task;
                }
            }
            if(mappyWithLinky.containsKey(temp1)) {
                if(!mappyWithLinky.get(temp1).contains(temp2))
                    mappyWithLinky.get(temp1).add(temp2);
            }
            else {
                mappyWithLinky.put(temp1,new LinkedList<>());
                mappyWithLinky.get(temp1).add(temp2);
            }
        }
        for (Task task: listOfTasks) {
            if(!mappyWithLinky.containsKey(task)) {
                mappyWithLinky.put(task,new LinkedList<>());
            }
        }
//        printDaMAP(mappyWithLinky);
        Graph graph = new Graph(mappyWithLinky);
        graph.topoSort();
    }
    private static void printDaMAP(HashMap<Task, LinkedList<Task>> mappyWithLinky) {
        for (Map.Entry<Task,LinkedList<Task>> entry: mappyWithLinky.entrySet()) {
            System.out.print(entry.getKey().name+ ": ");
            for (Task task: entry.getValue()) {
                System.out.print(task.name+" ");
            }
            System.out.println();
        }
    }
}
