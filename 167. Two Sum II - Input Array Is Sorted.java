// Binary search
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length-1; i++){
            int left = i+1; int right = numbers.length-1;
            while(left < right){
                int mid = left + (right - left)/2;
                if (numbers[mid]>= target - numbers[i]) {
                    right = mid;
                } else {left = mid + 1;}
            }
            if (numbers[left] + numbers[i] == target) {
                return new int[]{i+1, left+1};
                }
        }
        return new int[]{-1, -1};
    }
}


//Two pointers
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left < right) {
            if (numbers[left] + numbers[right] == target) return new int[]{left+1, right+1};
            if (numbers[left] + numbers[right] < target){
                left++;
            } else right--;
        }
    return new int[]{-1,-1};
    }
}