// Last updated: 21/06/2026, 21:36:00
1class Solution {
2    private void dfs(char[][] grid, int i, int j){
3        int m = grid.length;
4        int n = grid[0].length;
5
6         if (i < 0 || j < 0 || i >= m || j >= n 
7            || grid[i][j] == '0' 
8            || grid[i][j] == '2') {
9            return;
10        }
11
12        grid[i][j] = '2';
13
14        dfs(grid, i + 1, j);
15        dfs(grid, i - 1, j);
16        dfs(grid, i, j + 1);
17        dfs(grid, i, j - 1);
18    }
19    public int numIslands(char[][] grid) {
20        int count = 0;
21
22        for(int i = 0; i < grid.length; i++){
23            for(int j = 0; j < grid[0].length; j++){
24                if(grid[i][j] == '1'){
25                    dfs(grid, i, j);
26                    count++;
27                }
28            }
29        }
30
31        return count;
32    }
33}