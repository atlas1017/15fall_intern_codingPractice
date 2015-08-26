public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> prev = new ArrayList<Integer>();
        if(n == 0) {
            prev.add(0);
            return prev;
        }
            
        prev.add(0);
        prev.add(1);
        if(n == 1)
            return prev;
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 1; i < n; i++) {
            res = new ArrayList<Integer>();
            int len = prev.size();
            for(int j = 0; j < len; j++)
                res.add(prev.get(j));
            for(int j = 0; j < len; j++)
                res.add(prev.get(len - 1 - j) + (1 << i));
            prev = res;
        }
        return res;
    }
}