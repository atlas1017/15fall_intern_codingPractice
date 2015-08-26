public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int times = (len + 1) / 2;
        for(int i = 0; i < times; i++)
            help(matrix, i);
        return;
    }
    
    public void help(int[][] matrix, int index) {
        int size = matrix.length;
        int len = size - 1 - 2 * index;
        
        int x1 = index;
        int y1 = index;
        
        int x2 = index + len;
        int y2 = index;
        
        int x3 = index + len;
        int y3 = index + len;
        
        int x4 = index;
        int y4 = index + len;
        
        for(int i = 0; i < len; i++) {
           int temp = matrix[y1][x1];
           matrix[y1][x1] = matrix[y4][x4];
           matrix[y4][x4] = matrix[y3][x3];
           matrix[y3][x3] = matrix[y2][x2];
           matrix[y2][x2] = temp;
           
           x1++;
           y2++;
           x3--;
           y4--;
        }
        return;
    }
}