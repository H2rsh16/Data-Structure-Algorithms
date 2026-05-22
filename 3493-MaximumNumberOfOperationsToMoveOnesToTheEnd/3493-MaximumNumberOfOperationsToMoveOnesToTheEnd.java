// Last updated: 22/05/2026, 11:19:08
class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int blocks = 0;
        int ops = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                if (i == n - 1 || s.charAt(i + 1) == '1') {
                    blocks++;
                }
            } else { 
                ops += blocks;
            }
        }

        return ops;

    }
}