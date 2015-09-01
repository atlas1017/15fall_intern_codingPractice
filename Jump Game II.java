public class Solution {
    public int jump(int[] nums)
	{
		// the point is that we will split the range by steps
		// lets say 0 to 0 is the range of step 1 and 1 to m could be range of step 1
	    if(nums.length < 2)
	        return 0;
	    int start = 0;
	    int end = 0;
	    int cur = 0;
	    int count = 0;
	    while(end < nums.length - 1) {
	        count++;
	        for(int i = start; i <= end; i++) 
	            cur = Math.max(nums[i] + i, cur);
	        if(cur == end)
	            break;
	        start = end + 1;
	        end = cur;
	        if(end >= nums.length - 1)
	            return count;
	    }
	    return -1;
 	}
}