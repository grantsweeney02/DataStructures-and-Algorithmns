public class O_1 {
    public void log(int[] numbers) {
        //O(1) Constant
        System.out.println(numbers[1]);

        //O(1+1) --> O(1)
        System.out.println(numbers[1]);
        System.out.println(numbers[1]);
    }
}
