// Last updated: 22/05/2026, 11:23:23
class Solution {
    public int minSteps(int n) {
        if(n <= 1) return 0;

        int start = 0;
        int factor = 2;

        while(n > 1){
            while(n % factor == 0){
                start += factor;
                n /= factor;
            }
            factor++;
        }
        return start;
    }
}