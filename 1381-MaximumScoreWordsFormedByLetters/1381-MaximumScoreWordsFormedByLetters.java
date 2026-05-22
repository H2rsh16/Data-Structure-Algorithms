// Last updated: 22/05/2026, 11:22:10
class Solution {
    public int backtrack(String[] words, int[] freq, int[] score, int index){
        if(index == words.length) return 0;

        int max = backtrack(words, freq, score, index + 1);

        String word = words[index];
        int[] temp = new int[26];
        int wordScore = 0;
        boolean canForm = true;


        for(char c: word.toCharArray()){
            temp[c - 'a']++;

            if(temp[c - 'a'] > freq[c - 'a']){
                canForm = false;
            }

            wordScore += score[c - 'a'];
        }

        if(canForm){
            for(int i = 0; i < 26; i++){
                freq[i] -= temp[i];
            }

            max = Math.max(max, wordScore + backtrack(words, freq, score, index + 1));

            for(int i = 0; i < 26; i++){
                freq[i] += temp[i];
            }
        }

        return max;
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];

        for(char c: letters){
            freq[c - 'a']++;
        }

        return backtrack(words, freq, score, 0);
    }
}