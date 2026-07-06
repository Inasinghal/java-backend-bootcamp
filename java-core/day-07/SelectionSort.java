class Solution {
    void selectionSort(int[] arr) {
        int n = arr.length;
    
       for(int i=0; i< n-1; i++) {
           int minIndex = i;
           
           for(int  j=i+1;j<n;j++) {
               if(arr[j] < arr[minIndex]) {
                   minIndex = j;
               }
           }
           
           int temp=arr[minIndex];
           arr[minIndex]=arr[i];
           arr[i]= temp;
       }
    }
}

/*
Property	Value
Best	O(n²)
Average	O(n²)
Worst	O(n²)
Space	O(1)
Stable	❌ No
Adaptive	❌ No
In-place	✅ Yes
*/