public class Main {
    public static void main(String[] args) {
        // int[] numbers = new int[]{10,20,30};
        // System.out.println(numbers.length);
        // System.out.println(Arrays.toString(numbers));

        Array numbers = new Array(3);
        
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.removeAt(3);
        System.out.println(numbers.indexOf(10));
        numbers.print();
    }
}

// Vector
// Grows 100% of the size
// Synchronized -- only one thread can work on it at a time


// ArrayList
// Only takes in objects
// Can use generics
// Grows 50% of the size
// Non-Synchronized -- many threads can access it
// ArrayList<Integer> list = new ArrayList<>();

// list.add(10); // adds at end
// list.remove(0);
// list.indexOf(20);
// list.contains(20);
// list.size(10);
// list.toArray(); //  converts ArrayList to an array



// Space
// Static Arrays have fixed size
// If you dont know the size before hand, choose Dynamic Array or LinkedList
// Dynamic Array grow by 50%-100%

