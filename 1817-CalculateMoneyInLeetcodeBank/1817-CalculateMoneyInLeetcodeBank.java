// Last updated: 22/05/2026, 11:21:08
class Solution {
    public int totalMoney(int n) {
        int[] dp = new int[n + 1];
        int monday = 1;
        int today = monday;
        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            dp[i] = dp[i - 1] + today;

            today++;

            if(i % 7 == 0){
                monday++;
                today = monday;
            }
        }

        return dp[n];
    }
}