public class FindMaximumElement {
    public static void main(String[] args) {
        int[] arr = {1,8,7,56,90};
        System.out.println(largest(arr));
    }

    public static int largest(int[] arr) {
        // code here
        int largest = arr[0];

        for(int i=0;i<arr.length;i++) {
            if(largest < arr[i]) {
                largest = arr[i];
            }
        }

        return largest;

    }
}
