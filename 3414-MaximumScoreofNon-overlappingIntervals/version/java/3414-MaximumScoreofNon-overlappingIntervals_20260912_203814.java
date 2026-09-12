// Last updated: 12/09/2026, 20:38:14
1import java.util.*;
2
3class Solution {
4
5    static class Node {
6        long score;
7        int[] indices;
8
9        Node(long score, int[] indices) {
10            this.score = score;
11            this.indices = indices;
12        }
13    }
14
15    public int[] maximumWeight(List<List<Integer>> intervals) {
16
17        int n = intervals.size();
18
19        int[][] arr = new int[n][4];
20
21        for (int i = 0; i < n; i++) {
22            arr[i][0] = intervals.get(i).get(0);
23            arr[i][1] = intervals.get(i).get(1);
24            arr[i][2] = intervals.get(i).get(2);
25            arr[i][3] = i;
26        }
27
28        // Sort by ending position
29        Arrays.sort(arr, (a, b) -> {
30            if (a[1] != b[1]) {
31                return Integer.compare(a[1], b[1]);
32            }
33            return Integer.compare(a[0], b[0]);
34        });
35
36        Node[][] dp = new Node[n + 1][5];
37
38        for (int i = 0; i <= n; i++) {
39            for (int k = 0; k <= 4; k++) {
40                dp[i][k] = new Node(0, new int[0]);
41            }
42        }
43
44        for (int i = 1; i <= n; i++) {
45
46            int start = arr[i - 1][0];
47            int weight = arr[i - 1][2];
48            int originalIndex = arr[i - 1][3];
49
50            int prev = findPrevious(arr, i - 1, start);
51
52            for (int k = 1; k <= 4; k++) {
53
54                Node skip = dp[i - 1][k];
55
56                Node previous = dp[prev + 1][k - 1];
57
58                int[] newIndices =
59                    addIndex(previous.indices, originalIndex);
60
61                Node take = new Node(
62                    previous.score + weight,
63                    newIndices
64                );
65
66                dp[i][k] = better(skip, take);
67            }
68        }
69
70        return dp[n][4].indices;
71    }
72
73    private int findPrevious(int[][] arr, int current, int currentStart) {
74
75        int left = 0;
76        int right = current - 1;
77        int answer = -1;
78
79        while (left <= right) {
80
81            int mid = left + (right - left) / 2;
82
83            if (arr[mid][1] < currentStart) {
84                answer = mid;
85                left = mid + 1;
86            } else {
87                right = mid - 1;
88            }
89        }
90
91        return answer;
92    }
93
94    private int[] addIndex(int[] old, int index) {
95
96        int[] result = Arrays.copyOf(old, old.length + 1);
97
98        result[old.length] = index;
99
100        Arrays.sort(result);
101
102        return result;
103    }
104
105    private Node better(Node a, Node b) {
106
107        if (a.score > b.score) {
108            return a;
109        }
110
111        if (b.score > a.score) {
112            return b;
113        }
114
115        if (isLexicographicallySmaller(b.indices, a.indices)) {
116            return b;
117        }
118
119        return a;
120    }
121
122    private boolean isLexicographicallySmaller(int[] a, int[] b) {
123
124        int len = Math.min(a.length, b.length);
125
126        for (int i = 0; i < len; i++) {
127
128            if (a[i] < b[i]) {
129                return true;
130            }
131
132            if (a[i] > b[i]) {
133                return false;
134            }
135        }
136
137        return a.length < b.length;
138    }
139}