public class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int q = 1;
        if(nums.length < 2)
            return nums.length;
        while(q < nums.length) {
            if(nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
                q++;
            }
            else {
                while(q < nums.length && nums[q] == nums[p])
                    q++;
            }
        }
        return p + 1;
    }
}