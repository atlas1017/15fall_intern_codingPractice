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
                block[(i/3)*3 + j/3][index] = true;
            }
        }
        help(board, row, col, block, 0, 0);
        return;
    }
    
    // we need some feedback from this method telling if done
    // the process of DFS
    // we need one or more than one data structure(usually arrays for fast access) and a help method that 
    // would tell if the DFS would succeed under such situation -- usually a boolean method 
    // in the boolean method, we would handle with some things like how the DFS would terminate (success or failure)
    // and also what is the direction of transformation of states of DFS
    public boolean help(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int m, int n) {
        if(m >= 9) return true;
        if(n >= 9) return help(board, row, col, block, m + 1, 0);
        if(board[m][n] != '.') return help(board, row, col, block, m, n + 1);
            
        for(int num = 0; num < 9; num++) {
            if(row[m][num] || col[n][num] || block[(m/3)*3 + n/3][num])
                continue;
            board[m][n] = (char)(num + '1');
            row[m][num] = true;
            col[n][num] = true;
            block[(m/3)*3 + n/3][num] = true;
            if(help(board, row, col, block, m, n + 1)) 
                return true;
            board[m][n] = '.'; // even this problem guarantee a solution, this is necessary because some 
                               // steps before might have made the DFS totally a mess and we cannot find
                               // one based on such a situation
            row[m][num] = false;
            col[n][num] = false;
            block[(m/3)*3 + n/3][num] = false;
        }
        return false;
    }
}