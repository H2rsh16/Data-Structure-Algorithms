// Last updated: 17/06/2026, 16:29:32
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        String s = new String();
4        for(int i = 0; i < words.length; i++){
5            int sum = 0;
6            for(char ch: words[i].toCharArray()){
7                sum += weights[ch -'a'];
8            }
9            char c = (char) ('z' - (sum % 26));
10            s += c;
11        }
12
13        return s;
14    }
15}