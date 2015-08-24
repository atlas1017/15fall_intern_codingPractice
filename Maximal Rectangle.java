public class Solution {
    
    // 出错的点 ： char[][] 的比较 
    //             width的计算的两种情况 
    
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        // make the int[] based on the height of the matrix
        int res = 0;
        for(int i = 0; i < matrix[0].length; i++)
        {
            int[] height = new int[matrix.length];
            for(int j = 0; j < matrix.length; j++)
            {
                int pos = i;
                while(pos < matrix[0].length && matrix[j][pos] == '1')
                    pos++;
                height[j] = pos - i;
            }
            res = Math.max(res, getMax(height));
        }
        return res;
    }
    
    
    public int getMax(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int[] h = new int[height.length + 1];
        for(int i = 0; i < height.length; i++)
            h[i] = height[i];
        h[height.length] = 0;
        
        int res = 0;
        ArrayList<Integer> indexStack = new ArrayList<Integer>();
        for(int i = 0; i < h.length; i++)
        {
            if(indexStack.isEmpty() || h[indexStack.get(indexStack.size() - 1)] < h[i])
                indexStack.add(i);
            else
            {
                int oneIndex = indexStack.remove(indexStack.size() - 1);
                int hei = h[oneIndex];
                int wid = indexStack.isEmpty() ? i : i - indexStack.get(indexStack.size() - 1) - 1;
                res = Math.max(res, wid * hei);
                i--;
            }
        }
        return res;
    }
}