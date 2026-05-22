// Last updated: 22/05/2026, 11:26:25
import java.math.BigInteger;
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        int result = dividend / divisor;

        return result;   
    }
}