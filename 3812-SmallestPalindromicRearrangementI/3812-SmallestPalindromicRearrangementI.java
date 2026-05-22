// Last updated: 22/05/2026, 11:18:47
class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder half = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                middle = String.valueOf((char) (i + 'a'));
            }
            for (int j = 0; j < freq[i] / 2; j++) {
                half.append((char)(i + 'a'));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(half);
        result.append(middle);
        result.append(half.reverse());

        return result.toString();
    }
}