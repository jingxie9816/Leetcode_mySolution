class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,0, target);   
        return count;
    }

    public void dfs(int[] nums, int start, int target){
        int n = nums.length;
        if(n == start) {
            if(target == 0){
                count++; 
            }
        } else{
        dfs(nums, start+1, target - nums[start]);
        dfs(nums, start+1, target + nums[start]);
        }
    }
}