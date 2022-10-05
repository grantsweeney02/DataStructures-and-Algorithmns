import java.util.Arrays;

/*
    Queues
First In -> First Out  (FIFO)

Examples:
    Waiting in Line at Grocery Store

Use Cases:
    Printers
    TO-DO LIST - in order
    Operating Systems
    Web Servers
    Being on Hold with Support

Runtime

enqueue - adding item to back of queue
dequeue - removing item from front of queue
peek - looking at the item at the front of the queue
isEmpty - checks if the queue is empty
isFull - check if the queue is full

*********************
all runtimes are O(1)
*********************

 */


public class ArrayQueue {
    private int[] items;
    private int front = 0;
    private int rear = 0;
    private int count;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length) {
            throw new IllegalStateException();
        }
        items[rear] = item;
        rear++;
        count++;
    }

    public int dequeue() {
        int item = items[front];
        items[front] = 0;
        front++;
        count--;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
