// Last updated: 22/05/2026, 11:22:03
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
         int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        int left = 1, right = Math.min(m, n);
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (existsSquare(prefix, m, n, mid, threshold)) {
                answer = mid;
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean existsSquare(int[][] prefix, int m, int n, int k, int threshold) {
        for (int i = 0; i + k <= m; i++) {
            for (int j = 0; j + k <= n; j++) {
                int sum = prefix[i + k][j + k]
                        - prefix[i][j + k]
                        - prefix[i + k][j]
                        + prefix[i][j];
                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}