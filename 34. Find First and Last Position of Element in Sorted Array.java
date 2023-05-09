class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int left = searchBoundary(nums, low, high, target); //find the first >= target
        int right = searchBoundary(nums, low, high, target+1); //find the first > target
        if (left>= high+1 || nums[left] != target) return new int[]{-1, -1};
        return new int[]{left, right-1};
    }

    //find the index of the first integer that >= target 
    private int searchBoundary(int[] nums, int low, int high, int target){
        while (low<=high) {
            int mid = low + (high - low)/2;  // avoid integer overflow
            if (nums[mid] >= target) {
                high = mid-1;
            }
            else {low = mid + 1;}
        }
        return low;
    }

}