// Last updated: 22/05/2026, 11:25:27
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 1) return triangle.get(0).get(0);

        int[] dp = new int[n];
        List<Integer> lst = triangle.get(n - 1);

        for(int i = 0; i < n; i++){
            dp[i] = lst.get(i);
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}