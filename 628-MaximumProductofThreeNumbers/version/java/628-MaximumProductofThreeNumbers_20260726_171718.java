// Last updated: 26/07/2026, 17:17:18
1class Solution {
2    public int maximumProduct(int[] nums) {
3        Arrays.sort(nums);
4
5        int n = nums.length;
6
7        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
8        int option2 = nums[0] * nums[1] * nums[n - 1];
9
10        return Math.max(option1, option2);
11    }
12}