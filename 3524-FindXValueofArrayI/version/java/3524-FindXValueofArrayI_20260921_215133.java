// Last updated: 21/09/2026, 21:51:33
1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3
4        long[] result = new long[k];
5
6        long[] dp = new long[k];
7
8        for (int x : nums) {
9
10            long[] newDp = new long[k];
11
12            int rem = x % k;
13
14            newDp[rem]++;
15
16            for (int r = 0; r < k; r++) {
17                int newRem = (r * rem) % k;
18                newDp[newRem] += dp[r];
19            }
20
21            for (int r = 0; r < k; r++) {
22                result[r] += newDp[r];
23            }
24
25            dp = newDp;
26        }
27
28        return result;
29    }
30}