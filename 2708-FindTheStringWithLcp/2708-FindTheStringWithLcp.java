// Last updated: 22/05/2026, 11:19:45
class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;

        for (int i = 0; i < n; i++) {
            if (lcp[i][i] != n - i) return "";
            for (int j = 0; j < n; j++) {
                if (lcp[i][j] != lcp[j][i]) return "";
            }
        }

        char[] word = new char[n];
        for (int i = 0; i < n; i++) word[i] = '?';

        char ch = 'a';

        for (int i = 0; i < n; i++) {
            if (word[i] == '?') {
                if (ch > 'z') return "";

                for (int j = i; j < n; j++) {
                    if (lcp[i][j] > 0) {
                        word[j] = ch;
                    }
                }
                ch++;
            }
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word[i] == word[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] != lcp[i][j]) return "";
            }
        }

        return new String(word);
    }
}