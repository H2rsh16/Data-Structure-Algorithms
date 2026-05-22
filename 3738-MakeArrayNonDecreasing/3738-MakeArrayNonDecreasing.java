// Last updated: 22/05/2026, 11:18:56
class Solution {
    public int maximumPossibleSize(int[] nums) {
        int count = 0;
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int max = nums[i];
            int j = i + 1;

            while (j < n && max > nums[j]) {
                max = Math.max(max, nums[j]);
                j++;
            }

            count++;
            i = j;
        }

        return count;
    }
}