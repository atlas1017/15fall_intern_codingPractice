public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // DFS
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        boolean[][][] dp = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        dp[0][0][0] = true;
        
        for(int i = 1; i <= len3; i++)
            dp[0][0][i] = false;
        for(int i = 1; i <= len2; i++)
            dp[0][i][0] = false;
        for(int i = 1; i <= len1; i++)
            dp[i][0][0] = false;
        
       
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++)
                dp[i][j][0] = false;
        }
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len3; j++) {
                if(i != j)
                    dp[i][0][j] =  false;
                else
                    dp[i][0][j] = dp[i - 1][0][j - 1] && (s1.charAt(i - 1) == s3.charAt(j - 1));
            }
        }
        for(int i = 1; i <= len2; i++) {
            for(int j = 1; j <= len3; j++) {
                if(i != j)
                    dp[0][i][j] =  false;
                else
                    dp[0][i][j] = dp[0][i - 1][j - 1] && (s2.charAt(i - 1) == s3.charAt(j - 1));
            }
        }
        
       
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                for(int k = 1; k <= s3.length(); k++) {
                    if(i + j != k)
                        dp[i][j][k] = false;
                    else
                        dp[i][j][k] = (dp[i - 1][j][k - 1] && s1.charAt(i - 1) == s3.charAt(k - 1)) 
                                    || (dp[i][j - 1][k - 1] && s2.charAt(j - 1) == s3.charAt(k - 1));
                }
            }
        }
       
        return dp[len1][len2][len3];
    }
}