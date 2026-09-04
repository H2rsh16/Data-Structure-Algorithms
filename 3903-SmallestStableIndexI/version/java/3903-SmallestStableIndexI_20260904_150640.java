// Last updated: 04/09/2026, 15:06:40
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4
5        int[] suffixMin = new int[n];
6
7        suffixMin[n - 1] = nums[n - 1];
8
9        for (int i = n - 2; i >= 0; i--) {
10            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
11        }
12
13        int prefixMax = nums[0];
14
15        for (int i = 0; i < n; i++) {
16            prefixMax = Math.max(prefixMax, nums[i]);
17
18            int instability = prefixMax - suffixMin[i];
19
20            if (instability <= k) {
21                return i;
22            }
23        }
24
25        return -1;
26    }
27}