public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkCol(board) && checkBlock(board);
    }
    
    public boolean checkRow(char[][] board) {
        HashSet<Character> s = new HashSet<Character>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(!s.contains(board[i][j]))
                        s.add(board[i][j]);
                    else
                        return false;
                }
            }
            s = new HashSet<Character>();
        }
        return true;
    }
    
    public boolean checkCol(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> s = new HashSet<Character>(); 
            for(int j = 0; j < 9; j++) {
                char temp = board[j][i];
                if(temp != '.') {
                    if(s.contains(temp))
                        return false;
                    else
                        s.add(temp);
                }
            }
        }
        return true;
    }
    
    public boolean checkBlock(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> s = new HashSet<Character>();
            int x = i % 3;
            int y = i / 3;
            
            x *= 3;
            y *= 3;
            
            for(int m = 0; m < 3; m++) {
                for(int n = 0; n < 3; n++) {
                    char temp = board[x + m][y + n];
                    if(temp != '.') {
                        if(s.contains(temp))
                            return false;
                        else
                            s.add(temp);
                    }
                }
            }
        }
        return true;
    }
}