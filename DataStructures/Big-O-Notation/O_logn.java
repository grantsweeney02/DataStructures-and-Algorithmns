public class O_logn {
    public void log(int[] numbers) {
        // O(logn)
        for (int i = 1; i < n; i = i * 2){
            System.out.println("Hey - I'm busy looking at: " + i);
        }
    }


    public int binarySearch(int number[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
 
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
 
        // We reach here when element is not present
        // in array
        return -1;
    }

    //    000010000
    //    0010
    //    01
    //    1
}