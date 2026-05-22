// Last updated: 22/05/2026, 11:26:04
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }

        return max;
    }
}