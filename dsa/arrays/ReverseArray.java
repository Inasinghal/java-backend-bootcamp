import java.util.Arrays;
class ReverseArray {
    public static void reverseArray(int arr[]) {
        // code here
        for(int i=0;i<arr.length/2;i++) {
            int temp = arr[arr.length-1-i];
            arr[arr.length-1-i]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String args[]) {
        int[] arr = {1, 4, 3, 2, 6, 5};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}