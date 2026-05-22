// Last updated: 22/05/2026, 11:25:55
class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int l = 1;
        int r = x;
        int mid = -1;

        while(l <= r){
            mid = l + (r - l) / 2;

            if((long) mid * mid == (long) x){
                return mid;
            }
            else if((long) mid * mid < (long) x){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return Math.round(r);
    }
}