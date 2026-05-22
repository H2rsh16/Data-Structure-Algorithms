// Last updated: 22/05/2026, 11:18:57
class Solution {
    int[][] grid;
    int n, m;

    // Directions: ↘, ↙, ↖, ↗
    int[][] dirs = {
        {1, 1},   // 0
        {1, -1},  // 1
        {-1, -1}, // 2
        {-1, 1}   // 3
    };

    int[][][][][] memo;

    int expected(int seqIndex) {
        if (seqIndex == 0) return 1;
        return (seqIndex % 2 == 1) ? 2 : 0;
    }

    int dfs(int r, int c, int dir, int hasTurned, int seqIndex) {
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != expected(seqIndex)) {
            return 0;
        }

        int reducedSeqIdx = Math.min(seqIndex, 2);
        if (memo[r][c][dir][hasTurned][reducedSeqIdx] != -1) {
            return memo[r][c][dir][hasTurned][reducedSeqIdx];
        }

        int maxLen = 1;

        int nr = r + dirs[dir][0];
        int nc = c + dirs[dir][1];
        maxLen = Math.max(maxLen, 1 + dfs(nr, nc, dir, hasTurned, seqIndex + 1));

        if (hasTurned == 0) {
            int newDir = (dir + 1) % 4;
            int nr2 = r + dirs[newDir][0];
            int nc2 = c + dirs[newDir][1];
            maxLen = Math.max(maxLen, 1 + dfs(nr2, nc2, newDir, 1, seqIndex + 1));
        }

        memo[r][c][dir][hasTurned][reducedSeqIdx] = maxLen;
        return maxLen;
    }

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;

        memo = new int[n][m][4][2][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int d = 0; d < 4; d++)
                    for (int t = 0; t < 2; t++)
                        for (int s = 0; s < 3; s++)
                            memo[i][j][d][t][s] = -1;

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        int len = dfs(i, j, dir, 0, 0);
                        maxLength = Math.max(maxLength, len);
                    }
                }
            }
        }

        return maxLength;
    }
}
