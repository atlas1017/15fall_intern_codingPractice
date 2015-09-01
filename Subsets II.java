public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<Integer> ();
        helpAdding(res, one, nums, 0);
        return res;
    }
    
    public void helpAdding(List<List<Integer>> res, List<Integer> one, int[] nums, int pos)
    {
        List<Integer> copy = new ArrayList<Integer> (one);
        res.add(copy);
        int i = pos;
        while(i < nums.length) {
            one.add(nums[i]);
            helpAdding(res, one, nums, i+1);
            one.remove(one.size() - 1);
            
            // this line needs to be memorized for moving to the 
            // next different number or the end
            do{i++;} while(i < nums.length && nums[i - 1] == nums[i]);
        }
    }
}