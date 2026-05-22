// Last updated: 22/05/2026, 11:22:31
class Solution {
    public String gcdOfStrings(String str1, String str2) {
       if(!(str1 + str2).equals(str2 + str1)) return "";

       int idx = helper(str1.length(), str2.length());
       return str1.substring(0, idx);
    }
    public int helper(int a, int b){
        return b == 0 ? a : helper(b, a % b);
    }
}