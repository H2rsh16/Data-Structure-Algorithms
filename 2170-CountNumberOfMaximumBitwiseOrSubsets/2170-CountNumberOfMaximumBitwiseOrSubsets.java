// Last updated: 22/05/2026, 11:20:26
class Solution {
    private void helper(int[] nums, int i, int c, int max, int[] count){
        if(c == max){
            count[0]++;
        }

        for(int j = i; j < nums.length; j++){
            helper(nums, j + 1, c | nums[j], max, count);
        }
    }
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for(int num: nums){
            max |= num;
        }

        int[] count = new int[1];
        helper(nums, 0, 0, max, count);

        return count[0];
    }
}