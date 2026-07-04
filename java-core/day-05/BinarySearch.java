import java.util.Scanner;
import java.util.Arrays;
public class BinarySearch {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements separated by space");
        String line = sc.nextLine();
        String[] tokens = line.trim().split(" ");// Initialize the array's/
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }


        System.out.println("Enter target element");
        int target = sc.nextInt();
        int min = 0;
        int max= arr.length-1;
        int result = -1;

        while(min <= max) {
            int mid = (min+max)/2;
            if(arr[mid] == target) {
                result = mid;
                break;
            } else if(arr[mid] < target) {
                min = mid+1;
            } else {
                max= mid-1;
            }
        }

        System.out.println(result);
    }
}