public class Solution {
    
    // 输出所有的结果 往往用DFS
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> one = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        helpAdding(res, one, target, candidates, 0);
        return res;
    }
    
    public void helpAdding(List<List<Integer>> res, List<Integer> one, int target, int[] candidates, int start)
    {
        if(target == 0)
        {
            List<Integer> copy = new ArrayList<Integer> (one);
            res.add(copy);
            return;
        }
        
        for(int i = start; i < candidates.length; i++)
        {
            if(i > start && candidates[i] == candidates[i - 1])
                continue;
            if(candidates[i] <= target)
            {
                one.add(candidates[i]);
                helpAdding(res, one, target - candidates[i], candidates, i);
                one.remove(one.size() - 1);
            }
        }
        return;
    }
}