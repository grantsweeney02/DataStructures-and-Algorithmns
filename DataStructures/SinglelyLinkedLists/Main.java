package SingelyLinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SinglelyLinkedList list = new SinglelyLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        System.out.println(list.getFirst());
        System.out.println(list.size());
        System.out.println(list.kthNode(5));
        int[] array = list.toArray();
        System.out.println(Arrays.toString(array));
    }
}
