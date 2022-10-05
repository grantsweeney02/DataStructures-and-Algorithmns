/*
    ARRAYS
[0,1,2,3]

RUNTIMES
LOOKUP = O(1)
INSERT = O(n)
DELETE = O(n)
DELETE/INSERT (at end) = O(1)  // no shifting required


// Space
// Static Arrays have fixed size
// If you dont know the size before hand, choose Dynamic Array or LinkedList
// Dynamic Array grow by 50%-100%

*/



public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {
        if(items.length == count) { // if the Array needs to be resized
            int[] newItems = new int[count*2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[count] = item;
        count++;
    }

    public void removeAt(int index) {
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        
        for (int i = index; i < count; i++) {
            items[i] = items[i +1];
        }

        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if(items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int max() {
        int max= items[0];
        for (int i = 0; i < count; i++) {
            if(items[i]>max) {
                max=items[i];
            }
        }
        return max;
    }
}
