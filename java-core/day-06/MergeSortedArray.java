class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m-1;
        int r = n-1;
        int i = nums1.length-1;
        while (l >= 0 && r >= 0) {
            if(nums1[l] < nums2[r]) {
                nums1[i--] = nums2[r];
                r--;
            } else {
                nums1[i--] = nums1[l];
                l--;
            }
        }

        while(r >= 0) {
             nums1[i--] = nums2[r];
             r--;
        }
    }
}