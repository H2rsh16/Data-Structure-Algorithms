// Last updated: 22/05/2026, 11:24:10
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] s = ransomNote.toCharArray();
        Arrays.sort(s);
        char[] t = magazine.toCharArray();
        Arrays.sort(t);


        int m = s.length;
        int n = t.length;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            if(s[i] == t[j]){
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        if(i == m){
            return true;
        }

        return false;
    }
}