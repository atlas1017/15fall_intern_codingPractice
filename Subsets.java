public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<Integer>();
        helpAdding(res, one, nums, 0);
        return res;
    }
    
    public void helpAdding(List<List<Integer>> res, List<Integer> one, int[] nums, int pos) {
        List<Integer> copy = new ArrayList<Integer> (one);
        res.add(copy);
        for(int i = pos; i < nums.length; i++)
        {
            one.add(nums[i]);
            helpAdding(res, one, nums, i + 1);
            one.remove(one.size() - 1);
        }
        return;
    }
}