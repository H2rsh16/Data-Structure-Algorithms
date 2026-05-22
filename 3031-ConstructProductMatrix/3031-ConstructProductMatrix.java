// Last updated: 22/05/2026, 11:19:24
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int mod = 12345;

        long[] res = new long[size];
        long[] arr = new long[size];


        int idx = 0;
        for(int[] row: grid){
            for(int val: row){
                arr[idx++] = val % mod;
            }
        }

        res[0] = 1;
        for (int i = 1; i < size; i++) {
            res[i] = (res[i - 1] * arr[i - 1]) % mod;
        }

        long suffix = 1;
        for (int i = size - 1; i >= 0; i--) {
            res[i] = (res[i] * suffix) % mod;
            suffix = (suffix * arr[i]) % mod;
        }

        int[][] ans = new int[m][n];
        idx = 0;

        for (int i = 0; i < size; i++) {
            ans[idx / n][idx % n] = (int) res[i];
            idx++;
        }

        return ans;
    }
}