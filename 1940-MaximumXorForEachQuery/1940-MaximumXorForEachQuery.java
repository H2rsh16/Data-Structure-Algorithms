// Last updated: 22/05/2026, 11:20:52
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        int idx = n - 1;

        int preXor = 0;
        for(int i = 0; i < n; i++){
            preXor ^= nums[i];

            int max = (1 << maximumBit) - 1;
            result[idx--] = max ^ preXor;
        }

        return result;
    }
}