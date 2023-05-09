class Solution {
    int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int high){
        if (low>=high) {return;}
        
        int mid = low + (high-low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        
        int i = low; 
        int j = mid+1;
        int newIndex = 0;
    
        while(i<=mid && j <= high){     // until one of the two sub list has been all added to new int[]
            if(nums[i] <= nums[j]){
                tmp[newIndex] = nums[i];
                i++;
                newIndex++;
            }
            else {
                tmp[newIndex] = nums[j];
                j++;
                newIndex++;
            }
        }
        while(i<=mid){      // for the one still having left elements, add all of them into new int[]
            tmp[newIndex] = nums[i];
            i++;
            newIndex++;
        }
        while(j<=high){
            tmp[newIndex] = nums[j];
            j++;
            newIndex++;
        }
        for (int k = 0; k < high - low + 1; ++k) {  // need keep the changed array from next level recursion, so need to update the nums itself, tmp cannot be carried to other recursion cycle. 
            nums[k + low] = tmp[k]; // change only the position that the above array range has impact on. from low to high of this recursion
        }
    }
}