// Last updated: 22/05/2026, 11:25:17
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for(int n: nums){
            res ^= n;
        }

        return res;
    }
}