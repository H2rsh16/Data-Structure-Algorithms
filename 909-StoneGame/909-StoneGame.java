// Last updated: 22/05/2026, 11:22:48
class Solution {
    private int total(int[] piles, int i, int j){
        int sum = 0;
        for(int k = i; k <= j; k++){
            sum += piles[k];
        }
        return sum;
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = piles[i];
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= n - i; j++){
                int k = j + i - 1;

                dp[j][k] = Math.max(
                    piles[j] + (total(piles, j + 1, k) - dp[j + 1][k]),
                    piles[k] + (total(piles, j, k - 1) - dp[j][k - 1])
                );
            }
        }

        int stonesTotal = total(piles, 0, n - 1);

        return dp[0][n - 1] > stonesTotal / 2;
    }
}