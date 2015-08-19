public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++)
        {
            for(int j = i + 1; j < nums.length - 2; j++)
            {
                int s = j + 1;
                int t = nums.length - 1;
                while(s < t)
                {
                    int temp = nums[i] + nums[j] + nums[s] + nums[t];
                    if(temp == target)
                    {
                        List<Integer> one = new ArrayList<Integer>();
                        one.add(nums[i]);
                        one.add(nums[j]);
                        one.add(nums[s]);
                        one.add(nums[t]);
                        
                        //if(!res.contains(one))
                        res.add(one);
                        
                        do{s++;} while(s < t && nums[s - 1] == nums[s]);
                        do{t--;} while(s < t && nums[t + 1] == nums[t]);
                    }
                    else if(temp < target)
                    {
                        s++;
                    }
                    else
                    {
                        t--;
                    }
                }
                while(j < nums.length - 2 && nums[j+1] == nums[j])
                    j++;
            }
            while(i < nums.length - 3 && nums[i+1] == nums[i])
                i++;
        }
        return res;
    }
}