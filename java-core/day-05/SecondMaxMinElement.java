public class SecondMaxMinElement {
    public static void main(String args[]) {
        int[] arr = {100};

        int max = arr[0];
        int secMax = Integer.MIN_VALUE;
        int min = arr[0];
        int secMin = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++) {
            if(arr[i] > max) {
                secMax = max;
                max = arr[i];
            } else if(arr[i] < max && arr[i] > secMax) {
                secMax = arr[i];
            }
            
            if(arr[i] < min) {
                secMin = min;
                min = arr[i];
            } else if(arr[i] > min && arr[i] < secMin) {
                secMin = arr[i];
            }
        }

        System.out.printf("2nd Max %d, 2nd Min %d", secMax, secMin);


    }
}