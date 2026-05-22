// Last updated: 22/05/2026, 11:21:48
import java.util.*;

class Solution {

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dirs = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
        };

        int[][] typeDirs = {
            {}, 
            {0, 1},     
            {2, 3},     
            {0, 3},     
            {1, 3},     
            {0, 2},     
            {1, 2}      
        };

        int[] opposite = {1, 0, 3, 2};

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            int type = grid[x][y];

            for (int dir : typeDirs[type]) {
                int nx = x + dirs[dir][0];
                int ny = y + dirs[dir][1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) 
                    continue;

                int nextType = grid[nx][ny];

                boolean canEnter = false;
                for (int d : typeDirs[nextType]) {
                    int bx = nx + dirs[d][0];
                    int by = ny + dirs[d][1];
                    if (bx == x && by == y) {
                        canEnter = true;
                        break;
                    }
                }

                if (canEnter) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return visited[m - 1][n - 1];
    }
}