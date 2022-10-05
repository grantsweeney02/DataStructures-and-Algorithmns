package SingelyLinkedList;
/*
* Grow and Shrink Automatically
* Have a little more space complexity because they hold pointers


    LINKED LISTS
[head] --> [head.next] --> [tail] single-linked
[head] <--> [head.next] <--> [tail] doubly-linked

[head] = [value][address of next node]

RUNTIMES
LOOKUP = O(n)      //you might have to traverse to the end
INSERT = O(n)      //you might have to traverse to the end
DELETE = O(n)      //you might have to traverse to the end
INSERT/DELETE (At head) = O(1)   //Just create new node and have tail point to it

*/


import java.util.NoSuchElementException;

public class SinglelyLinkedList {
    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first; // head
    private Node last; // tail
    private int size;

    public void addFirst(int item) {
        Node node = new Node(item);
        if(isEmpty()) {
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int item) {
        Node node = new Node(item);

        if(isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    }
    public void removeFirst() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        }
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }
    public void removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        }
        else {
            var secondToLast = getPrevious(last);
            last = secondToLast;
            last.next = null;
        }
        size--;
    }
    private Node getPrevious(Node node) {
        Node current = first;
        while( current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }
    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while( current != null) {
            if (current.value == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index] = current.value;
            current = current.next;
            index++;
        }
        return array;
    }

    public void reverse() {
        // [10 -> 20 -> 30]  => [10 <- 20 <- 30]
        //  p     c     n
        //  n = c.next
        //  c.next = p
        

        Node previous = first;
        Node current = first.next;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }
    public int getFirst() {
        return first.value;
    }
    public int kthNode(int k) {
        Node current = first;
        int i = 0;
        while(i < size-k) {
            current = current.next;
            i++;
        }
        return current.value;
    }
}



