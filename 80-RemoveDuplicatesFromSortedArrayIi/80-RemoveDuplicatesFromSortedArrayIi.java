// Last updated: 22/05/2026, 11:25:46
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int idx = 1;
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]){
                count++;
            }
            else{
                count = 1;
            }

            if(count <= 2){
                nums[idx] = nums[i];
                idx++;
            }
        }

        return idx;
    }
}