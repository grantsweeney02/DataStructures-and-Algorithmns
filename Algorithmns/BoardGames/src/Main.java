import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("Please input the number of intersections in the neighborhood: ");
        int numOfIntersections = Integer.parseInt(scan.nextLine());
        if (numOfIntersections <= 0) {
            System.exit(0);
        }
//        System.out.println("Please input the number of roads between intersections: ");
        int numOfRoads = Integer.parseInt(scan.nextLine());
        if (numOfRoads <= 0) {
            System.exit(0);
        }
        Graph graph = new Graph(numOfIntersections);
//        int targetIntersection = numOfIntersections - 1;
        for (int i = 0; i < numOfRoads; i++) {
//            System.out.println("Input the road between intersections:");
            String roadBetweenIntersection = scan.nextLine();
            String[] intersections = roadBetweenIntersection.split(" ");
            int firstIntersection = Integer.parseInt(intersections[0]);
            int secondIntersection = Integer.parseInt(intersections[1]);
            graph.addRoad(firstIntersection, secondIntersection);
        }
//        graph.print();
//        System.out.println("Please input the number of dangerous intersections: ");
        int numOfDangerousIntersections = Integer.parseInt(scan.nextLine());
        graph.sortAll();
        for (int i = 0; i < numOfDangerousIntersections; i++) {
//            System.out.println("Please input a dangerous intersection: ");
            graph.handleDangerousIntersection(Integer.parseInt(scan.nextLine()));
        }
//        graph.print();
//        System.out.println("Here is the DFS Search");
        graph.DepthFirstSearch(0,numOfIntersections-1);
    }
}