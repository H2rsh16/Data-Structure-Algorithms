// Last updated: 22/05/2026, 11:21:14
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] map = new boolean[26];
        int count = words.length;

        for(char c: allowed.toCharArray()){
            map[c - 'a'] = true;
        }

        for(String w: words){
            for(char ch: w.toCharArray()){
                if(!map[ch - 'a']){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}