// Last updated: 22/05/2026, 11:26:58
class Solution {
    public String convert(String s, int numRows) {
        int k = numRows * 2 - 2;
        StringBuilder result = new StringBuilder();
        
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        for (int i = 0; i < numRows; i++) {
            int left = i;
            int right = k - i;
            
            if (i == 0 || i == numRows - 1) {
                right = s.length();
            }


            for (int j = 0; j < s.length() / numRows + 1; j++) {
                
                if (left < s.length()) {
                    result.append(s.charAt(left));
                }

                if (right < s.length()) {
                    result.append(s.charAt(right));
                }

                left += k;
                right += k;
            }
        }

        return result.toString();
    }
}