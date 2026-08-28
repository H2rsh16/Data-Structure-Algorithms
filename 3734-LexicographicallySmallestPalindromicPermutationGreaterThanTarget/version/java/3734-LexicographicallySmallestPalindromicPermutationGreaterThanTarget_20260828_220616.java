// Last updated: 28/08/2026, 22:06:16
1class Solution {
2    public String lexPalindromicPermutation(String s, String target) {
3
4        int n = s.length();
5
6        int[] freq = new int[26];
7
8        for (char c : s.toCharArray()) {
9            freq[c - 'a']++;
10        }
11
12        int odd = 0;
13        char middle = 0;
14
15        for (int i = 0; i < 26; i++) {
16            if (freq[i] % 2 == 1) {
17                odd++;
18                middle = (char) ('a' + i);
19            }
20        }
21
22        if (odd > 1) {
23            return "";
24        }
25
26        int[] half = new int[26];
27
28        for (int i = 0; i < 26; i++) {
29            half[i] = freq[i] / 2;
30        }
31
32        char[] left = new char[n / 2];
33
34        if (dfs(left, 0, half, target, middle)) {
35            return makePalindrome(left, middle);
36        }
37
38        return "";
39    }
40
41    private boolean dfs(
42            char[] left,
43            int pos,
44            int[] count,
45            String target,
46            char middle) {
47
48        int halfLen = left.length;
49
50        if (pos == halfLen) {
51            String palindrome = makePalindrome(left, middle);
52
53            return palindrome.compareTo(target) > 0;
54        }
55
56        for (int c = 0; c < 26; c++) {
57
58            if (count[c] == 0) {
59                continue;
60            }
61
62            left[pos] = (char) ('a' + c);
63            count[c]--;
64
65            boolean possible = canStillBeGreater(
66                    left,
67                    pos,
68                    target,
69                    middle
70            );
71
72            if (possible && dfs(left, pos + 1, count, target, middle)) {
73                return true;
74            }
75
76            count[c]++;
77        }
78
79        return false;
80    }
81
82    private boolean canStillBeGreater(
83            char[] left,
84            int pos,
85            String target,
86            char middle) {
87
88        int n = target.length();
89
90        for (int i = 0; i <= pos; i++) {
91
92            if (left[i] > target.charAt(i)) {
93                return true;
94            }
95
96            if (left[i] < target.charAt(i)) {
97                return false;
98            }
99        }
100
101        return true;
102    }
103
104    private String makePalindrome(char[] left, char middle) {
105
106        StringBuilder sb = new StringBuilder();
107
108        for (char c : left) {
109            sb.append(c);
110        }
111
112        if (middle != 0) {
113            sb.append(middle);
114        }
115
116        for (int i = left.length - 1; i >= 0; i--) {
117            sb.append(left[i]);
118        }
119
120        return sb.toString();
121    }
122}