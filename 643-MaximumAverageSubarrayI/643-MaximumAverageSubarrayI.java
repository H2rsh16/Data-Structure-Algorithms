// Last updated: 22/05/2026, 11:23:25
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        int n = nums.length;

        for(int i = 0 ; i < k; i++){
            max += nums[i];
        }
        
        double windowsum = max;

        for(int i = k; i < n; i++){
            windowsum += nums[i] - nums[i - k];
            max = Math.max(max, windowsum);
        }

        return max / k;
    }
}