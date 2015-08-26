public class Solution {
    public String reverseWords(String s) {
        int[] pos = new int[1];
        String res = "";
        String one = getNext(s, pos);
        while(!one.equals("")) {
            res = " " + res;
            res = one + res;
            one = getNext(s, pos);
        }
        if(res.equals(""))
            return res;
        else
            return res.substring(0, res.length() - 1);
    }
    
    public String getNext(String s, int[] pos) {
        int cur = pos[0];
        String res = "";
        while(cur < s.length() && s.charAt(cur) == ' ')
            cur++;
        while(cur < s.length() && s.charAt(cur) != ' ') {
            res += s.charAt(cur++);
        }
        pos[0] = cur;
        return res;
    }
}