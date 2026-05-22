// Last updated: 22/05/2026, 11:25:58
import java.math.BigInteger;
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        
        BigInteger num = new BigInteger(sb.toString());
        
        num = num.add(BigInteger.ONE);
        
        String str = num.toString();
        
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Character.getNumericValue(str.charAt(i));
        }
        
        return result;
    }
}