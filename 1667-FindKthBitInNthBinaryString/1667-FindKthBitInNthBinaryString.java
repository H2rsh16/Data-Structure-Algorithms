// Last updated: 22/05/2026, 11:21:29
class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int mid = (1 << (n - 1));
        
        if (k == mid) return '1';
        if (k < mid) return findKthBit(n - 1, k);
        int mirroredPos = mid - (k - mid);
        return invert(findKthBit(n - 1, mirroredPos));
    }
    
    private char invert(char c) {
        return c == '0' ? '1' : '0';
    }
}