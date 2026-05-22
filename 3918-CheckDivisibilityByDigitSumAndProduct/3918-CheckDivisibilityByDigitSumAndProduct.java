// Last updated: 22/05/2026, 11:18:34
class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProduct = 1;

        int temp = n;
        
        while (temp > 0) {
            int digit = temp % 10;
            digitSum += digit;
            digitProduct *= digit;
            temp /= 10;
        }

        int totalSum = digitSum + digitProduct;

        return n % totalSum == 0;
    }
}