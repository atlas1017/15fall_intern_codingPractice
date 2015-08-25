public class Solution {
    public int minCut(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int[] parts = new int[len + 1];
        for(int i = 0; i <= len; i++)
            parts[i] = i;
            
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++) 
            dp[i][i] = true;
        for(int i = 0; i < len - 1; i++) {
            if(arr[i] == arr[i + 1])
                dp[i][i + 1] = true;
        }
        for(int i = 2; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                dp[j][i + j] = dp[j + 1][j + i - 1] && arr[j] == arr[j + i];
            }
        }
        
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if(dp[i][j])
                    parts[j + 1] = Math.min(parts[j + 1], parts[i] + 1);
            }
        }
        
        return parts[len] - 1;
    }
}