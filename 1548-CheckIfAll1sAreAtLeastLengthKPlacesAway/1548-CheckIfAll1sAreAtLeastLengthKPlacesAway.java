// Last updated: 22/05/2026, 11:21:42
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int count = k;

        for(int num: nums){
            if(num == 1){
                if(count < k) return false;

                count = 0;
            }
            else {
                count++;
            }
        }

        return true;
    }
}