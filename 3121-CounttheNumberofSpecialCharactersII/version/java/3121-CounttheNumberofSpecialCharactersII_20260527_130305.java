// Last updated: 27/05/2026, 13:03:05
1class Solution {
2
3    public int numberOfSpecialChars(String word) {
4
5        int[] lowerLast = new int[26];
6        int[] upperFirst = new int[26];
7
8        Arrays.fill(lowerLast, -1);
9        Arrays.fill(upperFirst, -1);
10
11        int n = word.length();
12
13        for (int i = 0; i < n; i++) {
14
15            char c = word.charAt(i);
16
17            if (c >= 'a' && c <= 'z') {
18
19                lowerLast[c - 'a'] = i;
20
21            } else {
22
23                int idx = c - 'A';
24
25                if (upperFirst[idx] == -1) {
26                    upperFirst[idx] = i;
27                }
28            }
29        }
30
31        int ans = 0;
32
33        for (int i = 0; i < 26; i++) {
34
35            if (lowerLast[i] != -1 &&
36                upperFirst[i] != -1 &&
37                lowerLast[i] < upperFirst[i]) {
38
39                ans++;
40            }
41        }
42
43        return ans;
44    }
45}