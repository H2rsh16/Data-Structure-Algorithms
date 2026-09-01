// Last updated: 01/09/2026, 09:23:11
1class Solution {
2
3    static class State {
4        int r;
5        int c;
6        int energy;
7        int mask;
8
9        State(int r, int c, int energy, int mask) {
10            this.r = r;
11            this.c = c;
12            this.energy = energy;
13            this.mask = mask;
14        }
15    }
16
17    public int minMoves(String[] classroom, int energy) {
18
19        int m = classroom.length;
20        int n = classroom[0].length();
21
22        int startR = -1;
23        int startC = -1;
24
25        int[][] litterIndex = new int[m][n];
26
27        for (int[] row : litterIndex) {
28            Arrays.fill(row, -1);
29        }
30
31        int litterCount = 0;
32
33        for (int r = 0; r < m; r++) {
34            for (int c = 0; c < n; c++) {
35
36                char ch = classroom[r].charAt(c);
37
38                if (ch == 'S') {
39                    startR = r;
40                    startC = c;
41                }
42
43                if (ch == 'L') {
44                    litterIndex[r][c] = litterCount++;
45                }
46            }
47        }
48
49        if (litterCount == 0) {
50            return 0;
51        }
52
53        int allCollected = (1 << litterCount) - 1;
54
55        int maskCount = 1 << litterCount;
56
57        int totalStates = m * n * (energy + 1) * maskCount;
58
59        boolean[] visited = new boolean[totalStates];
60
61        ArrayDeque<State> queue = new ArrayDeque<>();
62
63        queue.offer(new State(startR, startC, energy, 0));
64
65        visited[getId(startR, startC, energy, 0, n, energy, maskCount)] = true;
66
67        int moves = 0;
68
69        int[] dr = {-1, 1, 0, 0};
70        int[] dc = {0, 0, -1, 1};
71
72        while (!queue.isEmpty()) {
73
74            int size = queue.size();
75
76            for (int i = 0; i < size; i++) {
77
78                State current = queue.poll();
79
80                int r = current.r;
81                int c = current.c;
82                int currEnergy = current.energy;
83                int mask = current.mask;
84
85                if (mask == allCollected) {
86                    return moves;
87                }
88
89                if (currEnergy == 0) {
90                    continue;
91                }
92
93                for (int d = 0; d < 4; d++) {
94
95                    int nr = r + dr[d];
96                    int nc = c + dc[d];
97
98                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
99                        continue;
100                    }
101
102                    if (classroom[nr].charAt(nc) == 'X') {
103                        continue;
104                    }
105
106                    int nextEnergy = currEnergy - 1;
107
108                    int nextMask = mask;
109
110                    if (classroom[nr].charAt(nc) == 'L') {
111                        int bit = litterIndex[nr][nc];
112                        nextMask |= (1 << bit);
113                    }
114
115                    if (classroom[nr].charAt(nc) == 'R') {
116                        nextEnergy = energy;
117                    }
118
119                    int id = getId(
120                        nr,
121                        nc,
122                        nextEnergy,
123                        nextMask,
124                        n,
125                        energy,
126                        maskCount
127                    );
128
129                    if (!visited[id]) {
130
131                        visited[id] = true;
132
133                        queue.offer(
134                            new State(
135                                nr,
136                                nc,
137                                nextEnergy,
138                                nextMask
139                            )
140                        );
141                    }
142                }
143            }
144
145            moves++;
146        }
147
148        return -1;
149    }
150
151    private int getId(
152        int r,
153        int c,
154        int energyLeft,
155        int mask,
156        int n,
157        int maxEnergy,
158        int maskCount
159    ) {
160        int position = r * n + c;
161
162        return (((position * (maxEnergy + 1)) + energyLeft)
163                * maskCount) + mask;
164    }
165}
166