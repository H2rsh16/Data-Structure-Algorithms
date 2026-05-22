// Last updated: 22/05/2026, 11:21:21
class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        
        max[0][0] = min[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            max[i][0] = max[i - 1][0] * grid[i][0];
            min[i][0] = max[i][0];
        }
        
        for (int j = 1; j < n; j++) {
            max[0][j] = max[0][j - 1] * grid[0][j];
            min[0][j] = max[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long val = grid[i][j];
                
                long a = val * max[i - 1][j];
                long b = val * min[i - 1][j];
                long c = val * max[i][j - 1];
                long d = val * min[i][j - 1];
                
                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        
        long res = max[m - 1][n - 1];
        int MOD = 1_000_000_007;
        
        if (res < 0) return -1;
        return (int)(res % MOD);
    }
}