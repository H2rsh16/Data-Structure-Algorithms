// Last updated: 07/09/2026, 17:45:21
1class Solution {
2    public int distinctSubseqII(String s) {
3        final long MOD = 1_000_000_007;
4
5        long dp = 1;
6
7        long[] last = new long[26];
8
9        for (char c : s.toCharArray()) {
10            int index = c - 'a';
11
12            long newDp = (2 * dp - last[index] + MOD) % MOD;
13
14            last[index] = dp;
15
16            dp = newDp;
17        }
18
19        return (int) ((dp - 1 + MOD) % MOD);
20    }
21}