// Last updated: 22/05/2026, 11:19:11
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 3 != 0){
                count++;
            }
        }

        return count;
    }
}