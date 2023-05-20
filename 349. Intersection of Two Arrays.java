class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        for (int i=0; i<nums1.length; i++){
            seen.add(nums1[i]);
        }
        for (int j=0; j<nums2.length; j++){
            if (seen.contains(nums2[j])) {
                result.add(nums2[j]);
            }
        }
        int[] arr = new int[result.size()];
        int index = 0;
        for (int num : result) {
            arr[index++] = num;
        }
        return arr;
    }
}