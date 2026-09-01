// Last updated: 01/09/2026, 09:31:07
1class Solution {
2    public int[] runningSum(int[] nums) {
3        for(int i = 1; i < nums.length; i++){
4            nums[i] = nums[i] + nums[i - 1];
5        }
6
7        return nums;
8    }
9}