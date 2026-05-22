// Last updated: 22/05/2026, 11:18:37
class Solution {
    public int mirrorDistance(int n) {
        int num = n;
        int sum = 0;

        while(num > 0){
            int r = num % 10;

            sum = (sum * 10) + r;

            num /= 10;
        }

        return Math.abs(n - sum);
    }
}