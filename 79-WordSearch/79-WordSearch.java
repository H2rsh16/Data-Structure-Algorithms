// Last updated: 22/05/2026, 11:25:48
class Solution {
    public boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int idx){
        if(idx == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(idx)){
            return false;
        }

        visited[i][j] = true;

        if(helper(board, word, visited, i + 1, j, idx + 1) ||
        helper(board, word, visited, i - 1, j, idx + 1) ||
        helper(board, word, visited, i, j + 1, idx + 1) ||
        helper(board, word, visited, i, j - 1, idx + 1)){
            return true;
        }

        visited[i][j] = false;

        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean result = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                result = helper(board, word, visited, i, j, 0);

                if(result) return true;
            }
        }

        return result;
    }
}