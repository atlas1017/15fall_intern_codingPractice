public class Solution {
    public int romanToInt(String s) {
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] roman = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        int res = help(s, str, roman);
        return res;
    }
    
    public int help(String s, String[] str, int[] roman) {
        int pos = 0;
        int cur = 0;
        int curLen = str[cur].length();
        int res = 0;
        while(cur < str.length) {
            curLen = str[cur].length();
            if(pos + curLen <= s.length() && s.substring(pos, pos + curLen).equals(str[cur])) {
                res += roman[cur];
                pos += curLen;
            }
            else
                cur++;
        }
        return res;
    }
}