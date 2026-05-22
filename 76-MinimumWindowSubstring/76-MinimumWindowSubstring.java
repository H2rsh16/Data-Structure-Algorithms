// Last updated: 22/05/2026, 11:25:49
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if((m == 0) || (n == 0) || (m < n)) return "";

        int[] map = new int[128];
        int count = n;
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;

        for(char c: t.toCharArray()){
            map[c]++;
        }

        while(end < m){
            if(map[s.charAt(end++)]-- > 0) count --;

            while(count == 0){
                if(end - start < minLen){
                    minStart = start;
                    minLen = end - start;
                }

                if(map[s.charAt(start++)]++ == 0) count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}