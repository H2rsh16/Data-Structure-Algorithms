// Last updated: 22/05/2026, 11:20:23
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.isEmpty()) return "";
        
        int cols = encodedText.length() / rows;
        StringBuilder result = new StringBuilder();
        
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int row = 0, col = startCol; row < rows && col < cols; row++, col++) {
                result.append(encodedText.charAt(row * cols + col));
            }
        }
        
        int end = result.length() - 1;
        while (end >= 0 && result.charAt(end) == ' ') {
            end--;
        }
        
        return result.substring(0, end + 1);
    }
}