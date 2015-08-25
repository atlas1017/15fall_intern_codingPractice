public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid == null)
            return 0;
        int row = obstacleGrid.length;
        if(row == 0)
            return 0;
        int col = obstacleGrid[0].length;
        
        int[][] dp = new int[row][col];
        int m = row;
        int n = col;
        
        int pos = 0;
        while(pos < m && obstacleGrid[pos][0] == 0)
            dp[pos++][0] = 1;
        pos = 0;
        while(pos < n && obstacleGrid[0][pos] == 0)
            dp[0][pos++] = 1;
        
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else
                    dp[i][j] = 0;
            }
        }
        
        return dp[row - 1][col - 1];
    }
}