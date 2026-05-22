// Last updated: 22/05/2026, 11:23:51
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;

        for (int d = 0; d < m + n - 1; d++) {
            List<Integer> intermediate = new ArrayList<>();

            int row = d < n ? 0 : d - n + 1;
            int col = d < n ? d : n - 1;

            while (row < m && col >= 0) {
                intermediate.add(mat[row][col]);
                row++;
                col--;
            }

            if (d % 2 == 0) {
                for (int i = intermediate.size() - 1; i >= 0; i--) {
                    result[index++] = intermediate.get(i);
                }
            } else {
                for (int val : intermediate) {
                    result[index++] = val;
                }
            }
        }

        return result;
    }
}