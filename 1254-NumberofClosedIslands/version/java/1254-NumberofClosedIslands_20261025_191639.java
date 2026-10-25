// Last updated: 25/10/2026, 19:16:39
1class Solution {
2    public int closedIsland(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        for (int i = 0; i < m; i++) {
7            dfs(grid, i, 0);
8            dfs(grid, i, n - 1);
9        }
10
11        for (int j = 0; j < n; j++) {
12            dfs(grid, 0, j);
13            dfs(grid, m - 1, j);
14        }
15
16        int count = 0;
17
18        for (int i = 1; i < m - 1; i++) {
19            for (int j = 1; j < n - 1; j++) {
20                if (grid[i][j] == 0) {
21                    count++;
22                    dfs(grid, i, j);
23                }
24            }
25        }
26
27        return count;
28    }
29
30    private void dfs(int[][] grid, int i, int j) {
31        int m = grid.length;
32        int n = grid[0].length;
33
34        if (i < 0 || i >= m || j < 0 || j >= n
35                || grid[i][j] == 1) {
36            return;
37        }
38
39        grid[i][j] = 1;
40
41        dfs(grid, i + 1, j);
42        dfs(grid, i - 1, j);
43        dfs(grid, i, j + 1);
44        dfs(grid, i, j - 1);
45    }
46}