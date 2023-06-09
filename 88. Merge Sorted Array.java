class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1; 
        while(i>=0 || j>=0){
            if (i==-1){
                nums1[i+j+1] = nums2[j--];  //i+j+1 = m-1+n-1+1 = m+n-1
            } else if (j==-1){
                nums1[i+j+1] = nums1[i--];
            } else if (nums1[i] > nums2[j]){
                nums1[i+j+1] = nums1[i--];
            } else {
                nums1[i+j+1] = nums2[j--];
            }
        }
    }
}