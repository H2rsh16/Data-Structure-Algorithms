// Last updated: 22/05/2026, 11:24:29
class Solution {
    private final String[] LessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    private final String[] Tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Twenty"};

    private final String[] Thousands = {"", "Thousand", "Million", "Billion"};

    public String helper(int num){
            if(num == 0){
                return "";
            }
            else if(num < 20){
                return LessThan20[num] + " ";
            }
            else if(num < 100){
                return Tens[num / 10] + " " + helper(num % 10);
            }
            else {
                return LessThan20[num / 100] + " Hundred " + helper(num % 100);
            }
    }

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }

        int i = 0;
        String words = "";

        while(num > 0){
            if( num % 1000 != 0){
                words = helper(num % 1000) + Thousands[i] + " " + words;
            }

            num /= 1000;
            i++;
        }

        return words.trim();
    }
}