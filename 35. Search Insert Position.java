public class Solution {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len; 
// 在初始化的时候，把 right 设置成 len，在一开始的时候就不需要特殊判断了。
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;  // or return right, both works, because when ending the while loop, right = left;
    }
}