public class Solution {
    public List<List<String>> partition(String s) {
        List<String> one = new ArrayList<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        helpAdding(s, res, one, 0);
        return res;
    }
    
    public void helpAdding(String s, List<List<String>> res, List<String> one, int pos) {
        if(pos == s.length()) {
            List<String> copy = new ArrayList<String>(one);
            res.add(copy);
            return;
        }
        for(int i = pos + 1; i <= s.length(); i++) {
            String temp = s.substring(pos, i);
            if(isPalin(temp)) {
                one.add(temp);
                helpAdding(s, res, one, i);
                one.remove(one.size() - 1);
            }
        }
        return;
    }
    
    public boolean isPalin(String s) {
        int p = 0;
        int q = s.length() - 1;
        while(p < q) {
            if(s.charAt(p++) != s.charAt(q--))
                return false;
        }
        return true;
    }
}