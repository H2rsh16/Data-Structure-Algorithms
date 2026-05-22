// Last updated: 22/05/2026, 11:26:56
class Solution {
    public int reverse(int x) {
        int temp = x;
        int sum = 0;


        while(temp != 0){
            int r = temp % 10;
            if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && r > 7)) {
                return 0;
            }
            if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && r < -8)) {
                return 0;
            }
            sum = (sum * 10) + r;
            temp = temp / 10;
        }

        return sum;
    }
}