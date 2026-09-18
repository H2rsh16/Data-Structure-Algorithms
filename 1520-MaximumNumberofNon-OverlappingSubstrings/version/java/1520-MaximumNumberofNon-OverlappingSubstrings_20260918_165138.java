// Last updated: 18/09/2026, 16:51:38
1import java.util.*;
2
3class Solution {
4
5    public List<String> maxNumOfSubstrings(String s) {
6
7        int n = s.length();
8
9        int[] first = new int[26];
10        int[] last = new int[26];
11
12        Arrays.fill(first, n);
13        Arrays.fill(last, -1);
14
15        for (int i = 0; i < n; i++) {
16            int c = s.charAt(i) - 'a';
17
18            first[c] = Math.min(first[c], i);
19            last[c] = i;
20        }
21
22        List<int[]> intervals = new ArrayList<>();
23
24        for (int c = 0; c < 26; c++) {
25
26            if (last[c] == -1) {
27                continue;
28            }
29
30            int left = first[c];
31            int right = last[c];
32
33            boolean valid = true;
34
35            for (int i = left; i <= right; i++) {
36
37                int current = s.charAt(i) - 'a';
38
39                if (first[current] < left) {
40                    valid = false;
41                    break;
42                }
43
44                right = Math.max(right, last[current]);
45            }
46
47            if (valid) {
48                intervals.add(new int[]{left, right});
49            }
50        }
51
52        intervals.sort((a, b) -> a[1] - b[1]);
53
54        List<String> answer = new ArrayList<>();
55
56        int previousEnd = -1;
57
58        for (int[] interval : intervals) {
59
60            int left = interval[0];
61            int right = interval[1];
62
63            if (left > previousEnd) {
64                answer.add(s.substring(left, right + 1));
65                previousEnd = right;
66            }
67        }
68
69        return answer;
70    }
71}