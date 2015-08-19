public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length - 2; i++)
        {
            int s = i + 1;
            int t = nums.length - 1;
            while(s < t)
            {
                int tempSum = nums[i] + nums[s] + nums[t];
                if(tempSum == target)
                    return target;
                else if(tempSum < target)
                {
                    if(target - tempSum < min)
                    {
                        min = target - tempSum;
                        sum = tempSum;
                    }
                    s++;
                }
                else
                {
                    if(tempSum - target < min)
                    {
                        min = tempSum - target;
                        sum = tempSum;
                    }
                    t--;
                }
            }
        }
        return sum;
}
}