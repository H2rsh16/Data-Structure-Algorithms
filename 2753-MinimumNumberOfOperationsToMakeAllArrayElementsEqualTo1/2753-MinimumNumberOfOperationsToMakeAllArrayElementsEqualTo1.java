// Last updated: 22/05/2026, 11:19:38
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int overallGcd = nums[0];
        for (int i = 1; i < n; i++) {
            overallGcd = gcd(overallGcd, nums[i]);
        }
        if (overallGcd > 1) return -1;

        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        if (ones > 0) {
            return n - ones;
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currentGcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                currentGcd = gcd(currentGcd, nums[j]);
                if (currentGcd == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return (minLen - 1) + (n - 1);
    }

    // Helper gcd function
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
