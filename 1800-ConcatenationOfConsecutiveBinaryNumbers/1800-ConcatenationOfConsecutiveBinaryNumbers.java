// Last updated: 22/05/2026, 11:21:11
class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int MOD = 1_000_000_007;
        int bitLength = 0;
        
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }
            
            result = ((result << bitLength) + i) % MOD;
        }
        
        return (int) result;
    }
}