public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0)
            return false;
        char[] arr = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == arr[0]) {
                    visited[i][j] = true;
                    boolean res = helpSearching(i, j, arr, board, 1, visited);
                    visited[i][j] = false;
                    if(res) return true;
                }
            }
        }
        return false;
    }
    
    public boolean helpSearching(int i, int j, char[] arr, char[][] board, int pos, boolean[][] visited) {
        // dir: 1 from left 2 from right 3 from up and 4 from down
        if(pos == arr.length)
            return true;
        char target = arr[pos];
        int row = board.length;
        int col = board[0].length;
        boolean res = false;
        // go up
        if(i > 0 && board[i - 1][j] == target && visited[i - 1][j] == false ) {
            visited[i - 1][j] = true;
            res = helpSearching(i - 1, j, arr, board, pos + 1, visited);
            visited[i - 1][j] = false;
            if(res) return true;
        }
        if(j > 0 && board[i][j - 1] == target && visited[i][j - 1] == false) {
            visited[i][j - 1] = true;
            res = helpSearching(i, j - 1, arr, board, pos + 1, visited);
            visited[i][j - 1] = false;
            if(res) return true;
        }
        if(i < row - 1 && board[i + 1][j] == target && visited[i + 1][j] == false) {
            visited[i + 1][j] = true;
            res = helpSearching(i + 1, j, arr, board, pos + 1, visited);
            visited[i + 1][j] = false;
            if(res) return true;
        }
        if(j < col - 1 && board[i][j + 1] == target && visited[i][j + 1] == false) {
            visited[i][j + 1] = true;
            res = helpSearching(i, j + 1, arr, board, pos + 1, visited);
            visited[i][j + 1] = false;
            if(res) return true;
        }
        return false;
    }
}