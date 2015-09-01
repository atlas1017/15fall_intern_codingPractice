public class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0)
            return false;
        visited = new boolean[board.length][board[0].length];
        char[] arr = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == arr[0]) {
                    if(helpSearching(i, j, arr, board, 0)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean helpSearching(int i, int j, char[] arr, char[][] board, int pos) {
        if(pos == arr.length)
            return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true || board[i][j] != arr[pos])
            return false;
        visited[i][j] = true;
        boolean res = helpSearching(i - 1, j, arr, board, pos + 1) || helpSearching(i + 1, j, arr, board, pos + 1)
                    ||helpSearching(i, j - 1, arr, board, pos + 1) || helpSearching(i, j + 1, arr, board, pos + 1);
        visited[i][j] = false;
        return res;
    }
}

// 总结 ： 1. recursive call 的时候 如果一开始不能确定是不是下一步是valid的有两种解决办法 -- 一是在进入call之前进行判断 如果不符合就不继续call这个
// method 另外一个方式是 在每个call开始的时候filter 对于哪些类型的input应该立刻终止
//        2. 边界判断 < 0 || >= .length
//        3. recursive call pos + 1 --> 下一步 