// Recursive function to generate all
// subsequences with sum of elements k
import java.util.*;

class GfG {

    static void findSubsequences(int[] arr, int k, int i,
                                 List<Integer> subarr, int currentSum) {

        // Base case: When we reach the end of the array,
        // add the current subsequence to the result
        if(i == arr.length){
            if(currentSum == k){
                for (int num : subarr) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            return;
        }


        if (currentSum > k)
            return;


        // Include the current element in
        // the subsequence
        subarr.add(arr[i]);

        // Recurse to the next element
        findSubsequences(
                arr, k, i+1, subarr, currentSum + arr[i]);

        // Backtrack: Remove the current element and explore
        // the next possibility
        subarr.remove(subarr.size() - 1);

        //  Do not include the current
        // element in the subsequence
        findSubsequences(
                arr, k, i+1, subarr, currentSum);

    }

    public static void main(String[] args) {
        int[] arr = { 17, 18, 6, 11, 2, 4 };
        int k = 6;
        List<Integer> subarr = new ArrayList<>();
        findSubsequences(arr, k, 0, subarr, 0);
    }
}