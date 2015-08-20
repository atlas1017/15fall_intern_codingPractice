public class Solution {
    public String longestPalindrome(String str) {
        int len = str.length();
        char[] s = str.toCharArray();
        int longestBegin = 0;
        int maxLen = 1;
        boolean [][] table = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            table[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s[i] == s[i+1]) {
                table[i][i+1] = true;
                longestBegin = i;
                maxLen = 2;
            }
        }
        
        for (int tempLen = 3; tempLen <= len; tempLen++) {
            for (int i = 0; i < len-tempLen+1; i++) {
                int j = i+tempLen-1;
                if (s[i] == s[j] && table[i+1][j-1]) {
                    table[i][j] = true;
                    longestBegin = i;
                    maxLen = tempLen;
                }
            }
        }
        return str.substring(longestBegin, maxLen + longestBegin);
    }
}