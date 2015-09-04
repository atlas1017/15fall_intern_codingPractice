public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2)
            return;
        if(max(nums)) {
            Arrays.sort(nums);
            return;
        }
        
        int i = 0;
        for(i = nums.length - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i])
                break;
        }
        
        int target = nums[i - 1];
        int index =  i;
        int swapPos = i;
        while(index < nums.length) {
            if(nums[index] > target && nums[index] < nums[i])
                swapPos = index;
            index++;
        }
        
        int temp = nums[swapPos];
        nums[swapPos] = nums[i - 1];
        nums[i - 1] = temp;
        
        int[] sorted = sortPart(nums, i);
        int pos = i;
        int count = 0;
        while(pos < nums.length) 
            nums[pos++] = sorted[count++];
        return;
    }
    public int[] sortPart(int[] nums, int start) {
        int[] res = new int[nums.length - start];
        int count = 0;
        while(start < nums.length) 
            res[count++] = nums[start++];
        Arrays.sort(res);
        return res;
    }
    
    public boolean max(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1])
                return false;
        }
        return true;
    }
}