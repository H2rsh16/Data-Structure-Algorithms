// Last updated: 22/05/2026, 11:24:26
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                
                idx++;
            }
        }
    }
}