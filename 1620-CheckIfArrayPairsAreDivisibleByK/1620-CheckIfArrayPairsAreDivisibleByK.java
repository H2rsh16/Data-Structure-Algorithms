// Last updated: 22/05/2026, 11:21:36
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];

        for(int num: arr){
            int r = (num % k + k) % k;
            freq[r]++;
        }

        if(freq[0] % 2 != 0) return false;

        for(int i = 1; i <= k / 2; i++){
            if(freq[i] != freq[k - i]) return false;
        }
        return true;
    }
}