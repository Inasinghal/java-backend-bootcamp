public class LargestPositionElement {
    public static void main(String args[]) {
        int[] arr = {5, 2, 7, 2, 9};
        int target = 2;
        int position = -1;

        for(int i=0;i<arr.length;i++) {
            if(arr[i] == target) {
                position = i;
            }
        } 

        System.out.println(position);
    }

    //Can be solved through Reverse Traversal, first element will be returned 
}