// Last updated: 22/05/2026, 11:24:35
class Solution {
    public int countDigitOne(int n) {
        int count = 0;

        for(long i = 1; i <= n; i *= 10){
            long divisor = i * 10;
            int quotient = (int) (n / divisor);
            int remainder = (int) (n % divisor);

            if(quotient > 0){
                count += quotient * i;
            }
            if(remainder >= i){
                count += Math.min(remainder - i + 1, i);
            }
        }

        return count;
    }
}