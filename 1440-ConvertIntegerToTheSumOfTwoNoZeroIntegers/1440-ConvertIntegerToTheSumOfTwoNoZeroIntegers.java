// Last updated: 22/05/2026, 11:21:59
class Solution {
    public boolean hasZero(int num){
        while(num > 0){
            if(num % 10 == 0) return true;

            num /= 10;
        }

        return false;
    }
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i <= n; i++){
            int a = i;
            int b = n - i;

            if(!hasZero(a) && !hasZero(b)) return new int[]{a, b};
        }

        return new int[]{-1, -1};
    }
}