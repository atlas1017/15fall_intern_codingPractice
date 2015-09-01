public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<Integer>();
        helpAdding(n, k, 1, res, one);
        return res;
    }
    
    public void helpAdding(int n, int k, int pos, List<List<Integer>> res, List<Integer> one) {
        if(one.size() == k) {
            List<Integer> copy = new ArrayList<Integer>(one);
            res.add(copy);
            return;
        }
        if(pos > n)
            return;
        for(int i = pos; i <= n; i++) {
            one.add(i);
            helpAdding(n, k, i + 1, res, one);
            one.remove(one.size() - 1);
        }
        return;
    }
}