// Last updated: 22/05/2026, 11:26:21
class Solution {
    public boolean isSafe(char[][] board, int row, int col, char val){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == val || board[i][col] == val){
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[startRow + i][startCol + j] == val){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean helper(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isSafe(board, i, j, c)){
                            board[i][j] = c;

                            if(helper(board)) return true;

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        helper(board);
    }
}
