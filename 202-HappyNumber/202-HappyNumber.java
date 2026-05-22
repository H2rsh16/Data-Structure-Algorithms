// Last updated: 22/05/2026, 11:24:43
class Solution {
    private int getSum(int n){
        int currSum = 0;

        while(n != 0){
            int r = (n % 10);
            currSum += r * r;
            n /= 10;
        }

        return currSum;
    }
    public boolean isHappy(int n) {
        int slow = getSum(n);
        int fast = getSum(getSum(n));

        while(slow != fast && fast != 1){
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }

        return fast == 1;
    }
}