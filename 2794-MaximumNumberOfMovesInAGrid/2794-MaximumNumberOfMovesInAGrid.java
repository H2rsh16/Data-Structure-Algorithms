// Last updated: 22/05/2026, 11:19:35
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        int maxMoves = 0;

        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, i, 0, dp));
        }

        return maxMoves;
    }

    private int dfs(int[][] grid, int row, int col, Integer[][] dp) {
        if (col == grid[0].length - 1) {
            return 0;
        }

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int max = 0;
        int currentValue = grid[row][col];

        if (row > 0 && col + 1 < grid[0].length && grid[row - 1][col + 1] > currentValue) {
            max = Math.max(max, 1 + dfs(grid, row - 1, col + 1, dp));
        }

        if (col + 1 < grid[0].length && grid[row][col + 1] > currentValue) {
            max = Math.max(max, 1 + dfs(grid, row, col + 1, dp));
        }

        if (row < grid.length - 1 && col + 1 < grid[0].length && grid[row + 1][col + 1] > currentValue) {
            max = Math.max(max, 1 + dfs(grid, row + 1, col + 1, dp));
        }

        dp[row][col] = max;
        return max;
    }
}