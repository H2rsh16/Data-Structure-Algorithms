// Last updated: 22/05/2026, 11:20:08
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        boolean[][] guarded = new boolean[m][n];

        for(int[] w: walls) grid[w[0]][w[1]] = 1;
        for(int[] g: guards) grid[g[0]][g[1]] = 2;

        for(int i = 0; i < m; i++){
            boolean seen = false;

            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) seen = false;
                else if(grid[i][j] == 2) seen = true;
                else if(seen) guarded[i][j] = true;
            }

            seen = false;

            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] == 1) seen = false;
                else if(grid[i][j] == 2) seen = true;
                else if(seen) guarded[i][j] = true;
            }
        }

        for(int j = 0; j < n; j++){
            boolean seen = false;

            for(int i = 0; i < m; i++){
                if(grid[i][j] == 1) seen = false;
                else if(grid[i][j] == 2) seen = true;
                else if(seen) guarded[i][j] = true;
            }

            seen = false;

            for(int i = m - 1; i >= 0; i--){
                if(grid[i][j] == 1) seen = false;
                else if(grid[i][j] == 2) seen = true;
                else if(seen) guarded[i][j] = true;
            }
        }


        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && !guarded[i][j]) count++;
            }
        }

        return count;
    }
}