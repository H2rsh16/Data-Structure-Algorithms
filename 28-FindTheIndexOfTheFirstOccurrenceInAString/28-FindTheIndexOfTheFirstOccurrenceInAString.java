// Last updated: 22/05/2026, 11:26:27
class Solution {
    public int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)){
            return -1;
        }

        return haystack.indexOf(needle);
    }
}