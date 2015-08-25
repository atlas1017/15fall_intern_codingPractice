public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0)
            return res;
        List<Integer> one = new ArrayList<Integer>();
        one.add(1);
        res.add(one);
        if(numRows == 1)
            return res;
        List<Integer> prev = new ArrayList<Integer>();
        for(int i = 2; i <= numRows; i++)
        {
            // handle all levels from 2 to numRow
            List<Integer> cur = new ArrayList<Integer>();
            int len = prev.size();
            cur.add(1);
            for(int j = 1; j < len; j++)
            {
                cur.add(prev.get(j - 1) + prev.get(j));
            }
            cur.add(1);
            res.add(cur);
            prev = cur;
        }
        return res;
    }
}