// Last updated: 22/05/2026, 11:20:09
class Solution {
    public String removeDigit(String number, char digit) {
        String maxResult = "";
        
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String newNumber = number.substring(0, i) + number.substring(i + 1);
                
                if (newNumber.compareTo(maxResult) > 0) {
                    maxResult = newNumber;
                }
            }
        }

        return maxResult;
    }
}