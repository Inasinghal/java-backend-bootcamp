class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        for(int i=1;i<arr.length;i++) {
            boolean shifted = 
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}

/*
Complexity
Case	Time
Best	O(n)
Average	O(n²)
Worst	O(n²)

Space

O(1)
Properties
Property	Value
Stable	✅ Yes
Adaptive	✅ Yes
In-place	✅ Yes
Best Case	O(n)
Worst Case	O(n²)*/