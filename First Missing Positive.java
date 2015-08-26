public class Solution {
    public int firstMissingPositive(int[] nums) {
        // because we want to find the fisrt missing
        // and with all these numbers we could only cover len numbers
        // swap them and if missing found, return; or return len + 1;
        
        int len = nums.length;
        int pos = 0;
        
        while(pos < len) {
            if(nums[pos] > 0 && nums[pos] <= len && nums[nums[pos] - 1] != nums[pos])
                swap(nums, pos, nums[pos] - 1); // this makes the nums[pos] "consistent" with its pos
            else
                pos++;
        }
        
        for(int i = 0; i < len; i++) {
            if(nums[i] != i + 1)
                return i + 1;
        }
        
        // did not find missing from 1 to n-1
        return len + 1;
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return;
    }
}