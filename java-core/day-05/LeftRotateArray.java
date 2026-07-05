import java.util.Arrays;
import java.util.Scanner;
public class LeftRotateArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements separated by space");
        String line = sc.nextLine();
        String[] tokens = line.trim().split(" ");// Initialize the array's/
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }


        System.out.println("Enter no. of rotations");
        int target = sc.nextInt();

        rotate(arr, target);
        System.out.println(Arrays.toString(arr));
    }

    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        reverse(nums, 0, nums.length-1);  
    }

    static void reverse(int[] arr, int left, int right) {
        while(left<right) {
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}


//for right rotate -> 
        k = k % nums.length;
        reverse(nums, k, nums.length-1);
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);