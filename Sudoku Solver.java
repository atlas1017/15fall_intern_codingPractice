public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9]; // first for row 
        boolean[][] col = new boolean[9][9]; // first for col
        boolean[][] block = new boolean[9][9]; // first for index of block
        
        // init 3 visited block
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char one = board[i][j];
                if(one == '.') continue;
                int index = one - '1';
                row[i][index] = true;
                col[j][index] = true;
                block[(i/3)*3 + j/3][index] = true; // calculation of the block position
            }
        }
        help(board, row, col, block, 0, 0);
        return;
    }
    
    // boolean as the return type 
    public boolean help(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int m, int n) {
        if(m >= 9) return true;
        if(n >= 9) return help(board, row, col, block, m + 1, 0);
        if(board[m][n] != '.') return help(board, row, col, block, m, n + 1);
            
        for(int num = 0; num < 9; num++) {
            if(row[m][num] || col[n][num] || block[(m/3)*3 + n/3][num])
                continue;
            board[m][n] = (char)(num + '1'); // this need to be cast forcefully or precision loss error
            row[m][num] = true;
            col[n][num] = true;
            block[(m/3)*3 + n/3][num] = true;
            if(help(board, row, col, block, m, n + 1)) 
                return true;
            board[m][n] = '.'; // still need to set back
            row[m][num] = false;
            col[n][num] = false;
            block[(m/3)*3 + n/3][num] = false;
        }
        return false;
    }
}