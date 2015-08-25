public class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int t = nums.length - 1;
        

        // the point is the proceeding condition for 
        // rotated and unrotated array should hold
        while(s < t - 1)
        {
            int mid = (s + t)/2;
            if(target == nums[mid])
                return mid;
            if(nums[mid] > nums[s])
            {
                if(target >= nums[s] && target < nums[mid])
                    t = mid - 1;
                else
                    s = mid + 1;
            }
            else
            {
                // on the t side
                if(target > nums[mid] && target <= nums[t])
                    s = mid + 1;
                else
                    t = mid - 1;
            }
        }
        
        if(nums[s] == target)
            return s;
        if(nums[t] == target)
            return t;
        else
            return -1;
    }
}