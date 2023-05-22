class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> intSet = new HashSet<>();
        boolean flag = false;
        for (int i:nums){
            flag = intSet.add(i);
            if (!flag) return true;
        }
        return false;
    }
}