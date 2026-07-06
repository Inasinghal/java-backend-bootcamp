class Solution {
    public void bubbleSort(int[] arr) {
        // code here
      int n = arr.length;
      for(int i=0;i<n-1;i++) {
          boolean swapped = false;
          for(int j=0;j<n-i-1;j++) {
              if(arr[j] > arr[j+1]) {
                  int temp = arr[j];
                  arr[j]=arr[j+1];
                  arr[j+1]=temp;
                  swapped = true;
              }
          }
          
          if(swapped == false) {
              break;
          }
      }
    }
}

/*
Property	Value
Best Time	O(n)
Average Time	O(n²)
Worst Time	O(n²)
Space	O(1)
Stable	✅ Yes
In-place	✅ Yes
Adaptive	✅ Yes (with swapped flag)
*/