public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer> ();
        
        int row = matrix.length;
        if(row == 0)
            return res;
        int col = matrix[0].length;
        if(col == 0)
            return res;
        int len = Math.min(row, col);
        int times = (len + 1) / 2;
        
        
        for(int i = 0; i < times; i++)
            adding(matrix, i, res);
        return res;
    }
    
    public void adding(int[][] matrix, int index, List<Integer> res) {
        int row = matrix.length - 1 - 2 * index;
        int col = matrix[0].length - 1 - 2 * index;
        
        int x1 = index;
        int y1 = index;
        
        if(row == 0) {
            for(int i = 0; i <= col; i++)
                res.add(matrix[y1][x1 + i]);
            return;
        }
        
        if(col == 0) {
            for(int i = 0; i <= row; i++)
                res.add(matrix[y1 + i][x1]);
            return;
        }
        
        int x2 = index + col;
        int y2 = index;
        
        int x3 = index + col;
        int y3 = index + row;
        
        int x4 = index;
        int y4 = index + row;
        
        // for row1
        for(int i = 0; i < col; i++){
            res.add(matrix[y1][x1 + i]);
        }
        
        // for col1
        for(int i = 0; i < row; i++) {
            res.add(matrix[y2 + i][x2]);
        }
        
        for(int i = 0; i < col; i++) {
            res.add(matrix[y3][x3 - i]);
        }
        
        for(int i = 0; i < row; i++) {
            res.add(matrix[y4 - i][x4]);
        }
        
        return;
    }
}