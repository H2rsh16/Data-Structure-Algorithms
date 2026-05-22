// Last updated: 22/05/2026, 11:20:02
class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int count = 0;
        int maxC = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(max == nums[i]){
                count++;
            }
            else{
                maxC = Math.max(maxC, count);
                count = 0;
            }
        }

        maxC = Math.max(maxC, count);
        if(maxC == 0) return 1;

        return maxC;
    }
}