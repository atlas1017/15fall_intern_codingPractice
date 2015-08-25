public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle == null || triangle.size() == 0)
            return 0;
        
        int len = triangle.size();
        int[][] res = new int[len][len];
        
        if(len == 1)
            return triangle.get(0).get(0);
        
        
        res[0][0] = triangle.get(0).get(0);
        // here i means the i + 1 level
        for(int i = 1; i < len; i++)
        {
            res[i][0] = res[i - 1][0] + triangle.get(i).get(0);
            for(int j = 1; j < i; j++)
                res[i][j] = Math.min(res[i - 1][j - 1], res[i - 1][j]) + triangle.get(i).get(j);
            res[i][i] = res[i - 1][i - 1] + triangle.get(i).get(i);
        }
        
        int min = res[len - 1][0];
        for(int i = 0; i < len; i++)
            min = res[len - 1][i] < min ? res[len - 1][i] : min;
        return min;
    }
}