// Last updated: 22/05/2026, 11:20:40
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last  = new int[26];

        for (int i = 0; i < 26; i++) {
            first[i] = Integer.MAX_VALUE;
            last[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = Math.max(last[c], i);
        }

        int result = 0;

        for (int c = 0; c < 26; c++) {
            if (first[c] >= last[c]) continue;

            int mask = 0;

            for (int i = first[c] + 1; i < last[c]; i++) {
                mask |= 1 << (s.charAt(i) - 'a');
            }

            result += Integer.bitCount(mask);
        }

        return result;
    }
}