// Last updated: 22/05/2026, 11:24:07
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;

        for(int j = 0; j < m; j++){
            if(i == n) return true;

            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
        }

        return i == n;
    }
}