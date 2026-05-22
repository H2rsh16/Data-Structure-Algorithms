// Last updated: 22/05/2026, 11:23:47
class Solution {
    public int helper(String a, String b){
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                int ans = 0;

                if(a.charAt(i) == b.charAt(j)){
                    ans = 1 + dp[i + 1][j + 1];
                }
                else {
                    ans = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }

                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);

        String rev = sb.reverse().toString();

        return helper(s, rev);
    }
}