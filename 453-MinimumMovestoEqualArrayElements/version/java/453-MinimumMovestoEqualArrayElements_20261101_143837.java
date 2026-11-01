// Last updated: 01/11/2026, 14:38:37
class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            sum += num;
        }
        return sum - (min * nums.length);
    }
}