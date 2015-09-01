public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        
        List<String> res = new ArrayList<String>();
        List<String> one = new ArrayList<String>();
        if(len < 4 || len > 12)
            return res;
        helpAdding(res, s, one, 0);
        return res;
    }
    
    public void helpAdding(List<String> res, String s, List<String> one, int pos) {
        if(one.size() == 4) {
            if(pos < s.length())
                return;
            String temp = "";
            for(String oneStr : one) {
               temp += ".";
               temp += oneStr;
            }
            res.add(temp.substring(1, temp.length()));
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(pos + i + 1 <= s.length()) {
                String next = s.substring(pos, pos + i + 1);
                if(inRange(next) && one.size() < 4) {
                    one.add(next);
                    helpAdding(res, s, one, pos + i + 1);
                    one.remove(one.size() - 1);
                }
            }
        }
    }
    
    public boolean inRange(String s) {
        if(s.length() == 1)
            return true;
        if(s.length() == 2 && s.charAt(0) != '0')
            return true;
        else {
            if(s.charAt(0) <= '0' || s.charAt(0) >= '3')
                return false;
            else if(s.charAt(0) == '1')
                return true;
            else if (s.charAt(1) < '5')
                return true;
            else if(s.charAt(1) == '5' && s.charAt(2) < '6')
                return true;
            else 
                return false;
        }
    }
}