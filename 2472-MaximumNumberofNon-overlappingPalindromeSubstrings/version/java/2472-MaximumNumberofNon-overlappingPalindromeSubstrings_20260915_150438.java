// Last updated: 15/09/2026, 15:04:38
1class Solution {
2    public int maxPalindromes(String s, int k) {
3        int n = s.length();
4
5        boolean[][] isPal = new boolean[n][n];
6
7        for (int i = n - 1; i >= 0; i--) {
8            for (int j = i; j < n; j++) {
9                if (s.charAt(i) == s.charAt(j) &&
10                    (j - i <= 2 || isPal[i + 1][j - 1])) {
11                    isPal[i][j] = true;
12                }
13            }
14        }
15
16        int[] dp = new int[n + 1];
17
18        for (int i = 1; i <= n; i++) {
19            dp[i] = dp[i - 1];
20
21            for (int j = 0; j <= i - k; j++) {
22                if (isPal[j][i - 1]) {
23                    dp[i] = Math.max(dp[i], dp[j] + 1);
24                }
25            }
26        }
27
28        return dp[n];
29    }
30}