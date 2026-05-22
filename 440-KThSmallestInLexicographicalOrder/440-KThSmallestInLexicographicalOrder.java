// Last updated: 22/05/2026, 11:24:03
class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;

        while(k > 0){
            int s = countSteps(current, n);

            if(k >= s){
                current++;
                k -= s;
            }
            else{
                current *= 10;
                k--;
            }
        }

        return current;
    }

    public int countSteps(int p, int n){
        long current = p;
        long next = p + 1;
        int t = 0;

        while(current <= n){
            t += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }

        return t;
    };
}