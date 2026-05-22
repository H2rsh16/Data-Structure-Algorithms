// Last updated: 22/05/2026, 11:20:47
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                min = Math.min(min, Math.abs(i - start));
            }
        }

        return min;
    }
}