// Last updated: 22/05/2026, 11:21:32
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            zeros[i] = count;
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int required = n - i - 1;
            int j = i;

            while (j < n && zeros[j] < required) {
                j++;
            }

            if (j == n) return -1;

            int value = zeros[j];
            while (j > i) {
                zeros[j] = zeros[j - 1];
                j--;
                swaps++;
            }
            zeros[i] = value;
        }

        return swaps;
    }
}