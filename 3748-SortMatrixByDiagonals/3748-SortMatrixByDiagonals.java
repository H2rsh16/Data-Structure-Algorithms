// Last updated: 22/05/2026, 11:18:54
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        int[][] diagonalBuckets = new int[2 * n - 1][n];
        int[] sizes = new int[2 * n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diagIndex = i - j + (n - 1);
                diagonalBuckets[diagIndex][sizes[diagIndex]++] = grid[i][j];
            }
        }

        for (int k = 0; k < diagonalBuckets.length; k++) {
            int[] diagonal = Arrays.copyOf(diagonalBuckets[k], sizes[k]);
            if (k >= n - 1) {
                Arrays.sort(diagonal);
                reverse(diagonal);
            } else {
                Arrays.sort(diagonal);
            }
            diagonalBuckets[k] = diagonal;
        }

        int[] pointers = new int[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diagIndex = i - j + (n - 1);
                grid[i][j] = diagonalBuckets[diagIndex][pointers[diagIndex]++];
            }
        }

        return grid;
    }

    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}