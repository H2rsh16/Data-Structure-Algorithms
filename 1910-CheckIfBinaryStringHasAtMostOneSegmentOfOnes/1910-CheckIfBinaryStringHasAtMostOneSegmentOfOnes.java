// Last updated: 22/05/2026, 11:20:55
class Solution {
    public boolean checkOnesSegment(String s) {
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == '0' && s.charAt(i) == '1') return false;
        }

        return true;
    }
}