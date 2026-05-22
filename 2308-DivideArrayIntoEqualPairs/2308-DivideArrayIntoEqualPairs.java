// Last updated: 22/05/2026, 11:20:12
class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);

        for(int j = 1; j < nums.length; j+=2){
            if(nums[j - 1] != nums[j]) return false;
        }

        return true;
    }
}