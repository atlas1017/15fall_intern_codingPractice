public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        ArrayList<Integer> cols = new ArrayList<Integer>();
        helpAdding(res, cols, 0, n);
        return res.size();
    }
    public void helpAdding(List<List<String>> res, ArrayList<Integer> cols, int i, int n) {
        if(i == n) {
            res.add(parse(cols));
            return;
        }
        for(int j = 0; j < n; j++) {
            if(cols.contains(j)) continue;
            if(isValid(cols, i, j)) {
                cols.add(j);
                helpAdding(res, cols, i + 1, n);
                cols.remove(cols.size() - 1);
            }
        }
        return;
    }
    public boolean isValid(ArrayList<Integer> cols, int i, int j) {
        for(int m = 0; m < i; m++) {
            if((i - m) == (j - cols.get(m)))
                return false;
            if((m - i) == (j - cols.get(m)))
                return false;
        }
        return true;
    }
    public List<String> parse(ArrayList<Integer> cols) {
        // string operation is pretty slow and here if I do that
        // it will cause a time limit exceeding
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < cols.size(); i++) {
            char[] one = new char[cols.size()];
            for(int j = 0; j < cols.size(); j++) 
                one[j] = '.';
            one[cols.get(i)] = 'Q';
            res.add(String.valueOf(one));
        }
        return res;
    }
}