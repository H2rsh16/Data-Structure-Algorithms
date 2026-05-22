// Last updated: 22/05/2026, 11:23:05
class Solution {
    private boolean isPrime(int n){
        if(n < 2) return false;

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }

        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for(int i = left; i <= right; i++){
            int setBits = Integer.bitCount(i);

            if(isPrime(setBits)) count++;
        }

        return count;
    }
}