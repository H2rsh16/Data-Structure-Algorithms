// Last updated: 26/05/2026, 13:16:10
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        boolean[] lower = new boolean[26];
4        boolean[] upper = new boolean[26];
5
6        for(char c : word.toCharArray()){
7            if(c >= 'a' && c <= 'z'){
8                lower[c - 'a'] = true;
9            }
10            else{
11                upper[c - 'A'] = true;
12            }
13        }
14
15        int count = 0;
16
17        for(int i = 0; i < 26; i++){
18            if(lower[i] && upper[i]) count++;
19        }
20
21        return count;
22    }
23}