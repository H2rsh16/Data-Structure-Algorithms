// Last updated: 22/05/2026, 11:21:30
class Solution {
    int m, n;
    boolean[][] visited;
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, int i, int j, int pi, int pj, char ch) {
        visited[i][j] = true;
        
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];
            
            if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
            if (grid[ni][nj] != ch) continue;
            
            if (!visited[ni][nj]) {
                if (dfs(grid, ni, nj, i, j, ch)) return true;
            } 
            else if (ni != pi || nj != pj) {
                return true;
            }
        }
        
        return false;
    }
}