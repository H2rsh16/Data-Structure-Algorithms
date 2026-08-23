// Last updated: 23/08/2026, 11:52:38
1class Solution {
2    public boolean sumGame(String num) {
3        int n = num.length();
4        int half = n / 2;
5
6        int diff = 0;
7        int leftQ = 0;
8        int rightQ = 0;
9
10        for (int i = 0; i < half; i++) {
11            char c = num.charAt(i);
12
13            if (c == '?') {
14                leftQ++;
15            } else {
16                diff += c - '0';
17            }
18        }
19
20        for (int i = half; i < n; i++) {
21            char c = num.charAt(i);
22
23            if (c == '?') {
24                rightQ++;
25            } else {
26                diff -= c - '0';
27            }
28        }
29
30        return 2 * diff != 9 * (rightQ - leftQ);
31    }
32}