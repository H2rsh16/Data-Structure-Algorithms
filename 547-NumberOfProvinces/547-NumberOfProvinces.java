// Last updated: 22/05/2026, 11:23:43
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int province = 0;

        for(int i =0; i < n; i++){
            if(!visited[i]){
                dfs(isConnected, visited, i);
                province++;
            }
        }

        return province;
    }
    private void dfs(int[][] arr, boolean[] visited, int city){
        visited[city] = true;

        for(int i = 0; i < arr.length; i++){
            if(arr[city][i] == 1 && !visited[i]){
                dfs(arr, visited, i);
            }
        }
    }
}