//XOR operation
class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i=1; i<nums.length; i++){
            ans = ans ^ nums[i];
        }
        return ans;
    }
}

//hashSet
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int result = -1;
        for (int num: nums){
            if (hashSet.contains(num)) {
                hashSet.remove(num);
            } else hashSet.add(num);
        }
        for (int num: hashSet){
            result = num;
        }
    return result;
    }
}
