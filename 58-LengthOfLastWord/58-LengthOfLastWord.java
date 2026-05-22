// Last updated: 22/05/2026, 11:26:01
class Solution {
    public int lengthOfLastWord(String s) {
        String arr[] = s.split(" ");

        return arr[arr.length - 1].length();
    }
}