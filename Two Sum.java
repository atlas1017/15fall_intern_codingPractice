public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for(int i=0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                res[0] = map.get(nums[i])+1;
                res[1] = i+1;
                return res;
            }
            else
             map.put(target - nums[i], i);
        }
        return res;
    }
}
