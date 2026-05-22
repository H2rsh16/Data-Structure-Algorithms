// Last updated: 22/05/2026, 11:26:22
class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                result = i;
            }
            else{
                if(nums[i] < target){
                    result = i + 1;
                }
            }
        }

        return result;
    }
}