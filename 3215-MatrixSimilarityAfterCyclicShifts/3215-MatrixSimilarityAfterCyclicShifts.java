// Last updated: 22/05/2026, 11:19:23
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        int shift = k % n;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                int expected;
                
                if (i % 2 == 0) {
                    expected = mat[i][(j + shift) % n];
                } else {
                    expected = mat[i][(j - shift + n) % n];
                }
                
                if (mat[i][j] != expected) {
                    return false;
                }
            }
        }
        
        return true;
    }
}