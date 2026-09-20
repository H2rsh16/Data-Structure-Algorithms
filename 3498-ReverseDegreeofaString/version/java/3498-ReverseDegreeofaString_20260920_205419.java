// Last updated: 20/09/2026, 20:54:19
// Easyyyyyyyyy
1class Solution {
2    public int reverseDegree(String s) {
3        int  ans = 0;
4
5        for(int i = 0; i < s.length(); i++){
6            char ch = s.charAt(i);
7
8            int rev = 26 - (ch - 'a');
9            ans += (i + 1) * rev;
10        }
11
12        return ans;
13    }
14}