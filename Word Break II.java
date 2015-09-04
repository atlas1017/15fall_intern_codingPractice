public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[s.length()] = true;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = s.length(); j > i; j--) {
                if(canBreak[j] && wordDict.contains(s.substring(i, j)))
                    canBreak[i] = true;
            }
        }
        HashSet<String> set = new HashSet<String>(wordDict);
        List<String> res = new ArrayList<String>();
        List<String> one = new ArrayList<String>();
        helpAdding(res, set, one, s, canBreak, 0);
        return res;
    }
    
    public void helpAdding(List<String> res, HashSet<String> dic, List<String> one, String s, boolean[] canBreak, int pos) {
        if(pos == s.length()) {
            char[] temp = new char[s.length() + one.size()];
            int cur = 0;
            for(int i = 0; i < one.size(); i++) {
                char[] oneArr = one.get(i).toCharArray();
                for(int j = 0; j < oneArr.length; j++) 
                    temp[cur++] = oneArr[j];
                temp[cur++] = ' ';
            }
            String oneStr = new String(temp);
            res.add(oneStr.substring(0, oneStr.length() - 1));
            return;
        }
        
        for(int i = pos + 1; i <= s.length(); i++) {
            if(dic.contains(s.substring(pos, i)) && canBreak[i]) {
                one.add(s.substring(pos, i));
                helpAdding(res, dic, one, s, canBreak, i);
                one.remove(one.size() - 1);
            }
        }
        return;
    }
}