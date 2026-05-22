// Last updated: 22/05/2026, 11:21:05
class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : allowedSwaps) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                dfs(i, graph, visited, comp);

                Map<Integer, Integer> freq = new HashMap<>();
                for (int idx : comp) {
                    freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
                }

                for (int idx : comp) {
                    int val = target[idx];
                    if (freq.getOrDefault(val, 0) > 0) {
                        freq.put(val, freq.get(val) - 1);
                    } else {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> comp) {
        visited[node] = true;
        comp.add(node);

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, graph, visited, comp);
            }
        }
    }
}