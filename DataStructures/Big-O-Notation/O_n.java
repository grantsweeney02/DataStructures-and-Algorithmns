public class O_n {
    public void log(int[] numbers, String[] names) {
        // O(n) --> n is size of input    Linear
        for(int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // O(1+n+1) --> O(n+2) --> O(n)
        System.out.println(1);
        for(int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println(1);


        // O(2n) --> O(n)
        for(int number: numbers) {
            System.out.println(number);
        }
        for(int number: numbers) {
            System.out.println(number);
        }


        //O(n)
        for(int number: numbers) {  //O(n)
            System.out.println(number);
        }
        for(String name: names) {   //O(m)
            System.out.println(name);
        }
    }
}