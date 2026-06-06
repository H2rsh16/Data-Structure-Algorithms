// Last updated: 07/06/2026, 00:05:46
1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int n = nums.length;
4        int[] ans = new int[n];
5
6        for (int i = 0; i < n; i++) {
7            int lsum = 0;
8            int rsum = 0;
9
10            for (int j = 0; j < i; j++) {
11                lsum += nums[j];
12            }
13
14            for (int j = i + 1; j < n; j++) {
15                rsum += nums[j];
16            }
17
18            ans[i] = Math.abs(lsum - rsum);
19        }
20
21        return ans;
22    }
23}