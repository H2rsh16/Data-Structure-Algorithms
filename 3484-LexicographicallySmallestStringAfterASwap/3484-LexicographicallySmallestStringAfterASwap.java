// Last updated: 22/05/2026, 11:19:09
class Solution {
    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 1; i < n; i++) {
            char a = chars[i - 1];
            char b = chars[i];

            if(a > b && a % 2 == b % 2){
                chars[i] = a;
                chars[i - 1] = b;
                return  new String(chars);
            }
        }
        return s;
    }
}