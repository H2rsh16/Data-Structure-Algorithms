// Last updated: 22/05/2026, 11:22:30
class Solution {
    private String rowToString(int[] row) {
        StringBuilder sb = new StringBuilder();
        for (int num : row) {
            sb.append(num);
        }
        return sb.toString();
    }
    private String flipRowToString(int[] row) {
        StringBuilder sb = new StringBuilder();
        for (int num : row) {
            sb.append(num == 0 ? "1" : "0");  // Flip 0 to 1 and 1 to 0
        }
        return sb.toString();
    }
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Map<String, Integer> rowMap = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
            String original = rowToString(matrix[i]);
            String flipped = flipRowToString(matrix[i]);
            
            rowMap.put(original, rowMap.getOrDefault(original, 0) + 1);
            rowMap.put(flipped, rowMap.getOrDefault(flipped, 0) + 1);
        }
        
        int maxRows = 0;
        for (int count : rowMap.values()) {
            maxRows = Math.max(maxRows, count);
        }
        
        return maxRows;
    }
}