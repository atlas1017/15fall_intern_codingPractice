public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // DFS
        if(s1.length() + s2.length() != s3.length())
            return false;
        return help(s1, 0, s2, 0, s3, 0);
    }
    
    public boolean help(String s1, int a, String s2, int b, String s3, int c) {
        if(a == s1.length() && b == s2.length() && c == s3.length())
            return true;
        boolean res = false;
        if(a < s1.length() && c < s3.length() && s3.charAt(c) == s1.charAt(a))
            res = help(s1, a + 1, s2, b, s3, c + 1);
        if(res == true)
            return true;
        if(b < s2.length() && c < s3.length() && s3.charAt(c) == s2.charAt(b))
            res = help(s1, a, s2, b + 1, s3, c + 1);
        return res;
    }
}