public class Solution {
    public int[][] generateMatrix(int n) {
        int cur = 1;
        int times = (n + 1) /2;
        int len = n - 1;
        
        int[][] res = new int[n][n];
        
        for(int i = 0; i < times; i++)
        {
            help(res, cur, len, i);
            cur += 4 * len;
            len -= 2;
        }
        
        return res;
    }
    
    public void help(int[][] res, int num, int len, int start) {
        // different from the rotating problem because
        // for that problem we could jsut ignore the last step
        // but for this one, the last position is not filled with number
        if(len == 0) {
            res[start][start] = num;
            return;
        }
        
        int x1 = start;
        int y1 = start;
        
        int x2 = start + len;
        int y2 = start;
        
        int x3 = start + len;
        int y3 = start + len;
        
        int x4 = start;
        int y4 = start + len;
        
        for(int i = 0; i < len; i++) {
            res[y1][x1] = num;
            res[y2][x2] = num + len;
            res[y3][x3] = num + 2 * len;
            res[y4][x4] = num + 3 * len;
            
            num++;
            x1++;
            y2++;
            x3--;
            y4--;
        }
        return;
    }
}