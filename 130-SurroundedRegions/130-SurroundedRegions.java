// Last updated: 22/05/2026, 11:25:23
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;

        // DFS from border 'O's
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0, n, m);
            dfs(board, i, m - 1, n, m);
        }
        for (int j = 0; j < m; j++) {
            dfs(board, 0, j, n, m);
            dfs(board, n - 1, j, n, m);
        }

        // Convert the board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded region
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // Border-connected region
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'O') return;

        board[i][j] = '#'; // Mark as visited and not surrounded

        dfs(board, i + 1, j, n, m);
        dfs(board, i - 1, j, n, m);
        dfs(board, i, j + 1, n, m);
        dfs(board, i, j - 1, n, m);
    }
}
