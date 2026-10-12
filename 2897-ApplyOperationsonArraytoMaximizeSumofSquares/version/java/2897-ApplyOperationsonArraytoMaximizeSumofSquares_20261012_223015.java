// Last updated: 12/10/2026, 22:30:15
1class Solution {
2    public int maxSum(List<Integer> nums, int k) {
3         final long MOD = 1_000_000_007L;
4        int[] bits = new int[31];
5
6        for (int num : nums) {
7            for (int b = 0; b < 31; b++) {
8                if ((num & (1 << b)) != 0) {
9                    bits[b]++;
10                }
11            }
12        }
13
14        long ans = 0;
15
16        for (int i = 0; i < k; i++) {
17            long num = 0;
18
19            for (int b = 0; b < 31; b++) {
20                if (bits[b] > 0) {
21                    num |= (1L << b);
22                    bits[b]--;
23                }
24            }
25
26            ans = (ans + num * num) % MOD;
27        }
28
29        return (int) ans;
30    }
31}