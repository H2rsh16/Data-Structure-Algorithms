// Last updated: 22/05/2026, 11:24:18
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }
}