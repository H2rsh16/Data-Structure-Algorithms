// Last updated: 22/05/2026, 11:23:57
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String sub = doubled.substring(1, doubled.length() - 1);

        // abababab
        return sub.contains(s);
    }
}