// Last updated: 26/05/2026, 13:09:23
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        boolean[] lower = new boolean[26];
4        boolean[] upper = new boolean[26];
5
6        for(char c: word.toCharArray()){
7            if(c >= 'a' && c <= 'z'){
8                lower[c - 'a'] = true;
9            }
10            else{
11                upper[c - 'A'] = true;
12            }
13        }
14
15
16        int count = 0;
17
18        for(int i = 0; i < 26; i++){
19            if(lower[i] && upper[i]){
20                count++;
21            }
22        }
23
24        return count;
25    }
26}