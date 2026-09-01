// Last updated: 01/09/2026, 09:22:20
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
25        // litterIndex[r][c] tells which bit belongs to this litter.
26        int[][] litterIndex = new int[m][n];
27
28        for (int[] row : litterIndex) {
29            Arrays.fill(row, -1);
30        }
31
32        int litterCount = 0;
33
34        // Find S and assign bit numbers to L
35        for (int r = 0; r < m; r++) {
36            for (int c = 0; c < n; c++) {
37
38                char ch = classroom[r].charAt(c);
39
40                if (ch == 'S') {
41                    startR = r;
42                    startC = c;
43                }
44
45                if (ch == 'L') {
46                    litterIndex[r][c] = litterCount++;
47                }
48            }
49        }
50
51        // No litter to collect
52        if (litterCount == 0) {
53            return 0;
54        }
55
56        int allCollected = (1 << litterCount) - 1;
57
58        /*
59         * State:
60         *     position = r * n + c
61         *     energy   = remaining energy
62         *     mask     = collected litter
63         *
64         * Encode all of them into one integer.
65         */
66
67        int maskCount = 1 << litterCount;
68
69        int totalStates = m * n * (energy + 1) * maskCount;
70
71        boolean[] visited = new boolean[totalStates];
72
73        ArrayDeque<State> queue = new ArrayDeque<>();
74
75        // Initial state
76        queue.offer(new State(startR, startC, energy, 0));
77
78        visited[getId(startR, startC, energy, 0, n, energy, maskCount)] = true;
79
80        int moves = 0;
81
82        int[] dr = {-1, 1, 0, 0};
83        int[] dc = {0, 0, -1, 1};
84
85        while (!queue.isEmpty()) {
86
87            int size = queue.size();
88
89            // Process one BFS level
90            for (int i = 0; i < size; i++) {
91
92                State current = queue.poll();
93
94                int r = current.r;
95                int c = current.c;
96                int currEnergy = current.energy;
97                int mask = current.mask;
98
99                // All litter collected
100                if (mask == allCollected) {
101                    return moves;
102                }
103
104                // If no energy remains, we cannot make another move.
105                // A valid state with 0 energy can only continue if
106                // it is on R, but R immediately resets the energy.
107                if (currEnergy == 0) {
108                    continue;
109                }
110
111                for (int d = 0; d < 4; d++) {
112
113                    int nr = r + dr[d];
114                    int nc = c + dc[d];
115
116                    // Outside grid
117                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
118                        continue;
119                    }
120
121                    // Obstacle
122                    if (classroom[nr].charAt(nc) == 'X') {
123                        continue;
124                    }
125
126                    // Moving costs 1 energy
127                    int nextEnergy = currEnergy - 1;
128
129                    int nextMask = mask;
130
131                    // Collect litter
132                    if (classroom[nr].charAt(nc) == 'L') {
133                        int bit = litterIndex[nr][nc];
134                        nextMask |= (1 << bit);
135                    }
136
137                    // Reset area
138                    if (classroom[nr].charAt(nc) == 'R') {
139                        nextEnergy = energy;
140                    }
141
142                    int id = getId(
143                        nr,
144                        nc,
145                        nextEnergy,
146                        nextMask,
147                        n,
148                        energy,
149                        maskCount
150                    );
151
152                    if (!visited[id]) {
153
154                        visited[id] = true;
155
156                        queue.offer(
157                            new State(
158                                nr,
159                                nc,
160                                nextEnergy,
161                                nextMask
162                            )
163                        );
164                    }
165                }
166            }
167
168            moves++;
169        }
170
171        return -1;
172    }
173
174    private int getId(
175        int r,
176        int c,
177        int energyLeft,
178        int mask,
179        int n,
180        int maxEnergy,
181        int maskCount
182    ) {
183        int position = r * n + c;
184
185        return (((position * (maxEnergy + 1)) + energyLeft)
186                * maskCount) + mask;
187    }
188}
189