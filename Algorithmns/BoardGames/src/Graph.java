import java.util.*;

public class Graph {
    private final boolean[] visited;
    private final List<Integer>[] adjList;
    private final int[] pathTo;

    public Graph(int intersection) {
        visited = new boolean[intersection];
        pathTo = new int[intersection];
        adjList = (List<Integer>[]) new List[intersection];
        for (int i = 0; i < intersection; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addRoad(int intersection1, int intersection2) {
        if(intersection2 != 0 && !adjList[intersection1].contains(intersection2)) {
            adjList[intersection1].add(intersection2);
        }
        if(intersection1 != 0 && !adjList[intersection2].contains(intersection1)) {
            adjList[intersection2].add(intersection1);
        }
    }

    public void sortAll() {
        for (List<Integer> integers : adjList) {
            Collections.sort(integers);
        }
    }
    public void handleDangerousIntersection(int dangerousIntersection) {
        adjList[dangerousIntersection].clear();
        for (List<Integer> integers : adjList) {
            if (integers.contains(dangerousIntersection)) {
                integers.remove((Integer) dangerousIntersection);
            }
        }
    }

    public void print() {
        for (int i = 0; i < adjList.length; i++) {
            System.out.print(i + ": ");
            int j=0;
            for (int intersection: adjList[i]) {
                if(j==0) {
                    System.out.print(""+intersection);
                    j++;
                }
                else {
                    System.out.print("-"+intersection);
                }
            }
            System.out.println();
        }
    }

    public void DepthFirstSearch(int sourceNode,int targetIntersection) {
        visited[sourceNode] = true;
        if(sourceNode == targetIntersection) {
            printPath(targetIntersection);
        }
        for(int road: adjList[sourceNode]) {
            if(!visited[road]) {
                pathTo[road] = sourceNode;
                DepthFirstSearch(road,targetIntersection);
            }
        }
        visited[sourceNode] = false;
    }

    public Stack<Integer> pathTo(int targetIntersection) {
        if (!visited[targetIntersection]) {
            return null;
        }
        Stack<Integer> pathStack = new Stack<>();
        int sourceNode = 0;
        for (int pathToTargetIntersection = targetIntersection; pathToTargetIntersection != sourceNode; pathToTargetIntersection = pathTo[pathToTargetIntersection]) {
            pathStack.push(pathToTargetIntersection);
        }
        pathStack.push(sourceNode);
        reverseStack(pathStack);
        return pathStack;
    }
    public void reverseStack(Stack<Integer> stackToBeReverse) {

        if (stackToBeReverse.isEmpty()) {
            return;
        }
        int bottom = popBottomStack(stackToBeReverse);
        reverseStack(stackToBeReverse);
        stackToBeReverse.push(bottom);
    }
    private int popBottomStack(Stack<Integer> stackToBeReverse) {
        int popTopStack = stackToBeReverse.pop();
        if (stackToBeReverse.isEmpty()) {
            return popTopStack;
        }
        int bottomStack = popBottomStack(stackToBeReverse);
        stackToBeReverse.push(popTopStack);
        return bottomStack;
    }
    // I got the idea of using a print method using the stacks from online URL: https://stackoverflow.com/questions/34475513/depth-first-search-more-than-one-solution

    public void printPath(int targetIntersection) {
        if (visited[targetIntersection]) {
//            System.out.println("Path to Goal: ");
            for (int x : pathTo(targetIntersection)) {
                if (x == targetIntersection) {
                    System.out.print(x);
                } else {
                    System.out.print(x + " - ");
                }
            }
            System.out.println();
        }
    }
}