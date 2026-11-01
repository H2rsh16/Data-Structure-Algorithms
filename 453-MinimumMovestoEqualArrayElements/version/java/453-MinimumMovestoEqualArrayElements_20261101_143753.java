// Last updated: 01/11/2026, 14:37:53
1class Solution {
2    public int minMoves(int[] nums) {
3        int sum = 0;
4        int min = nums[0];
5         
6        for(int num: nums){
7            min = Math.min(min, num);
8            sum += num;
9        }
10
11
12        return sum - (nums.length * min);
13    }
14}