// Last updated: 22/05/2026, 11:23:10
class Solution {
    public int helperDP(int[] cost, int i, int[] arr){
        if(i == 0) return cost[0];
        if(i == 1) return cost[1];


        if(arr[i] != -1) return arr[i];

        arr[i] = cost[i] + Math.min(helperDP(cost, i - 1, arr), helperDP(cost, i - 2, arr));
        return arr[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] temp = new int[n + 1];

        temp[0] = cost[0];
        temp[1] = cost[1];

        for(int i = 2; i < n; i++){
            temp[i] = cost[i] + Math.min(temp[i - 1], temp[i - 2]);
        }
        return Math.min(temp[n - 1], temp[n - 2]);
    }
}