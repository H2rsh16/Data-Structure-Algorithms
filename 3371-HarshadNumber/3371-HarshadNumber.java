// Last updated: 22/05/2026, 11:19:16
class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int y = x;

        while(y > 0){
            int r = y % 10;
            y /= 10;
            sum += r;
        }

        return x % sum == 0 ? sum : -1;
    }
}