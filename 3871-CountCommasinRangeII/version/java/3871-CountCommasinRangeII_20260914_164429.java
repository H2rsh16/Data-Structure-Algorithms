// Last updated: 14/09/2026, 16:44:29
1class Solution {
2    public long countCommas(long n) {
3        long res = 0;
4        long lower = 1000;
5        long commas = 1;
6
7        while(lower <= n){
8            long upper = lower * 1000 - 1;
9            if(upper > n) upper = n;
10
11            long countNumbers = upper - lower + 1;
12
13            res += (countNumbers * commas);
14
15            lower *= 1000;
16            commas++;
17        }
18
19        return res;
20    }
21}