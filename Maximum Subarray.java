public class Solution {
    public int maxSubArray(int[] nums) {
        if(allNeg(nums))
        {
            int max = nums[0];
            for(int one : nums)
                max = one > max ? one : max;
            return max;
        }
        
        int cur = 0;
        int max = 0;
        int tempSum = 0;
        while(cur < nums.length)
        {
            tempSum += nums[cur++];
            max = tempSum > max ? tempSum : max;
            tempSum = tempSum < 0 ? 0 : tempSum;
        }
        return max;
    }
    
    public boolean allNeg(int[] nums)
    {
        for(int one : nums)
        {
            if(one >= 0)
                return false;
        }
        return true;
    }
}