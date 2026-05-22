// Last updated: 22/05/2026, 11:25:54
class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int allways = 0;

        for(int i = 3; i <= n; i++){
            allways = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = allways;
        }

        return allways;
    }
}