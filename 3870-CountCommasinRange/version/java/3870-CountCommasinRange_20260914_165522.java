// Last updated: 14/09/2026, 16:55:22
1class Solution {
2    public int countCommas(int n) {
3        int p = 1000;
4        int res = 0;
5        while(p <= n){
6            res += n - p + 1;
7            p *= 1000;
8        }
9
10        return res;
11    }
12}