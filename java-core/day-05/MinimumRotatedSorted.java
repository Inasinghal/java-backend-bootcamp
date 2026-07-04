import java.util.Scanner;
public class MinimumRotatedSorted {
    public static void main(String args[]) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements separated by space");
        String line = sc.nextLine();
        String[] tokens = line.trim().split(" ");// Initialize the array's/
        int[] nums = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        int low = 0;
        int high= nums.length-1;
        int result = -1;

        while(low <= high) {
            if (nums[low] <= nums[high]) {
                break;
            }
            int mid = (low+high)/2;
            if(nums[mid] >= nums[low]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        System.out.println(nums[low]);
    }

    //Search in Rotated Array with Duplicates -> chck if mid==low==high -> low++; high--;
}