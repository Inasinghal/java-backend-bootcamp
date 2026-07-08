class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here

        List<Integer> subarr = new ArrayList<>();
        return findSubsequences(arr, k, 0, subarr, 0);
    }

    static boolean findSubsequences(int[] arr, int k, int i,
                                    List<Integer> subarr, int currentSum) {

        // Base case: When we reach the end of the array,
        // add the current subsequence to the result
        if(i == arr.length){
            if(currentSum == k){
                return true;
            }
            return false;
        }


        if (currentSum > k)
            return false;

        // Include the current element in
        // the subsequence
        subarr.add(arr[i]);

        // Recurse to the next element
        boolean result;
        result = findSubsequences(
                arr, k, i+1, subarr, currentSum + arr[i]);
        if(result) {
            return true;
        }

        // Backtrack: Remove the current element and explore
        // the next possibility
        subarr.remove(subarr.size() - 1);

        //  Do not include the current
        // element in the subsequence
        result = findSubsequences(
                arr, k, i+1, subarr, currentSum);
        if(result) {
            return true;
        }
        return false;

    }


}