// Last updated: 22/05/2026, 11:22:36
class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        int rookRow = 0, rookCol = 0;
        
        outer:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break outer;
                }
            }
        }
        
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for (int[] dir : dirs) {
            int r = rookRow;
            int c = rookCol;
            
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                r += dir[0];
                c += dir[1];
                
                if (r < 0 || r >= 8 || c < 0 || c >= 8) break;
                if (board[r][c] == 'B') break;
                if (board[r][c] == 'p') {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}
