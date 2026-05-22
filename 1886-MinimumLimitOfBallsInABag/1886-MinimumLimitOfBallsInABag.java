// Last updated: 22/05/2026, 11:20:59
class Solution {
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private boolean canDivide(int[] nums, int target, int maxOperations) {
        int operations = 0;
        
        for (int num : nums) {
            if (num > target) {
                operations += (num - 1) / target;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        
        return operations <= maxOperations;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = getMax(nums);
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, mid, maxOperations)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}