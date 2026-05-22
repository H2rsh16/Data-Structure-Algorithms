// Last updated: 22/05/2026, 11:22:00
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        boolean[] visited = new boolean[n];

        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int i, boolean[] visited){
        int n = arr.length;

        if(i < 0 || i >= n || visited[i]) return false;

        if(arr[i] == 0) return true;

        visited[i] = true;

        return dfs(arr, i + arr[i], visited) || dfs(arr, i - arr[i], visited);
    }
}