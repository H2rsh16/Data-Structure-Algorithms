// Last updated: 22/05/2026, 11:26:49
class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num = num - values[i];
                result.append(romanLetters[i]);
            }
        }
        return result.toString();
    }
}