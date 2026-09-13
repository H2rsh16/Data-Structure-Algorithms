// Last updated: 13/09/2026, 14:51:59
1class Solution {
2    public int largestOverlap(int[][] img1, int[][] img2) {
3        int n = img1.length;
4        int max = 0;
5
6        for (int r = -(n - 1); r <= n - 1; r++) {
7            for (int c = -(n - 1); c <= n - 1; c++) {
8                int count = 0;
9
10                for (int i = 0; i < n; i++) {
11                    for (int j = 0; j < n; j++) {
12                        int x = i + r;
13                        int y = j + c;
14
15                        if (x >= 0 && x < n && y >= 0 && y < n) {
16                            if (img1[i][j] == 1 && img2[x][y] == 1) {
17                                count++;
18                            }
19                        }
20                    }
21                }
22
23                max = Math.max(max, count);
24            }
25        }
26
27        return max;
28    }
29}
30