// Last updated: 22/05/2026, 11:18:43
class Solution {
    public int countPartitions(int[] nums, int k) {
         int n = nums.length;
        final int MOD = 1_000_000_007;

        long[] dp = new long[n + 1]; 
        long[] prefix = new long[n + 1];
        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> minD = new ArrayDeque<>();
        Deque<Integer> maxD = new ArrayDeque<>();

        int left = 0;

        for (int i = 0; i < n; i++) {

            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[i])
                maxD.pollLast();
            maxD.addLast(i);

            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[i])
                minD.pollLast();
            minD.addLast(i);

            while (!minD.isEmpty() && !maxD.isEmpty()
                    && nums[maxD.peekFirst()] - nums[minD.peekFirst()] > k) {

                if (maxD.peekFirst() == left) maxD.pollFirst();
                if (minD.peekFirst() == left) minD.pollFirst();
                left++;
            }

            // Valid partitions end at i → starts from [left..i]
            long validWays = prefix[i] - (left == 0 ? 0 : prefix[left - 1]);
            validWays = (validWays % MOD + MOD) % MOD;

            dp[i + 1] = validWays;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }
}