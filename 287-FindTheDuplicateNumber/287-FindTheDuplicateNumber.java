// Last updated: 22/05/2026, 11:24:24
class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]){
                return nums[i];
            }
        }

        return 0;
    }
}