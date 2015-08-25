public class Solution {
    public String longestPalindrome(String str) {
        int length = str.length();
        char[] arr = str.toCharArray();
        boolean[][] dp = new boolean[length][length];
        int start = 0;
        int max = 1;
        
        for(int i = 0; i < length; i++)
            dp[i][i] = true;
            
        for(int i = 0; i < length - 1; i++){
            if(arr[i] == arr[i + 1]){
                max = 2;
                dp[i][i + 1] = true;
                start = i;
            }
        }
            
        for(int len = 3; len < str.length() + 1; len++) {
            for(int i = 0; i < str.length() - len + 1; i++) {
                dp[i][i + len - 1] = dp[i + 1][i + len - 2] && (arr[i] == arr[i + len - 1]);
                if(dp[i][i + len - 1] && len > max) {
                    start = i;
                    max = len;
                }
            }
        }
        
        return str.substring(start, start + max);
    }
}