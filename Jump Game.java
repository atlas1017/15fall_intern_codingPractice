public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2)
            return true;
        int far = 0;
        for(int i = 0; i < nums.length; i++)
        {
            far = Math.max(far - 1, nums[i]);
            if(far == 0)
                return false;
            if(i + far > nums.length - 2)
                return true;
        }
        return true;
    }
}