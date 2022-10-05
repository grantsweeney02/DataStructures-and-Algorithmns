import java.util.Arrays;

/*
Stacks: Last In - First out  (LIFO)

Uses an array or linkedlist to store objects

Use Cases:
    - Undo feature
    - Build Compilers
    - Evaluate expression
    - Forward and Back Buttons -> webpages

Push(item) -> adds item to top
Pop() -> remove item from top
Peek() -> looks at item on top without removing it
isEmpty() -> checks if there are any items in the stack

Runtimes
push    -> O(1)
pop     -> O(1)
peek    -> O(1)
isEmpty -> O(1)

 */
public class Stack {
    // [10, 20, 30, 40, 50]
    // count = 5
    // push(10)
    // array[count] = 10 && count++
    // pop(50)
    // array[count] = 0 && count--
    
    private int[] items = new int[5];
    private int count;

    public void push(int item) {
        if(count == items.length) {
            throw new StackOverflowError();
        }
        items[count++] = item;
    }

    public int pop() {
        if(count == 0) {
            throw new IllegalStateException();
        }
        return items[--count];
    }

    public int peek() {
        if ( count == 0 ) {
            throw new IllegalStateException();
        }
        return items[count - 1];
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }

    public boolean isEmpty() {
        return count == 0;
    }




}
