public class O_n^2 {
    public void log(int[] numbers) {
        // O(n * n) --> O(n^2)  Quadratic
        for(int first: numbers) {
            for(int second: numbers) {
               System.out.println(first + ", " + second);
            }
        }


        // O(n + n^2) --> O(n^2)
        for(int number: numbers) {
            System.out.println(numbers);
        }
        for(int first: numbers) {
            for(int second: numbers) {
                System.out.println(first + ", " + second);
            }
        }
    }
}