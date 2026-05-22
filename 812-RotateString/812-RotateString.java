// Last updated: 22/05/2026, 11:22:59
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;


        return (s + s).contains(goal);
    }
}