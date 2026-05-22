// Last updated: 22/05/2026, 11:22:09
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        int min1_1 = Integer.MAX_VALUE, min1_2 = Integer.MAX_VALUE;
        int min2_1 = Integer.MAX_VALUE, min2_2 = Integer.MAX_VALUE;

        for (int n : nums) {
            sum += n;
            int r = n % 3;

            if (r == 1) {
                if (n < min1_1) {
                    min1_2 = min1_1;
                    min1_1 = n;
                } else if (n < min1_2) {
                    min1_2 = n;
                }
            } else if (r == 2) {
                if (n < min2_1) {
                    min2_2 = min2_1;
                    min2_1 = n;
                } else if (n < min2_2) {
                    min2_2 = n;
                }
            }
        }

        if (sum % 3 == 0)
            return sum;

        int ans = 0;

        if (sum % 3 == 1) {
            int optionA = (min1_1 == Integer.MAX_VALUE) ? 0 : sum - min1_1;

            int optionB = (min2_2 == Integer.MAX_VALUE) ? 0 : sum - (min2_1 + min2_2);

            ans = Math.max(optionA, optionB);
        } else {
            int optionA = (min2_1 == Integer.MAX_VALUE) ? 0 : sum - min2_1;

            int optionB = (min1_2 == Integer.MAX_VALUE) ? 0 : sum - (min1_1 + min1_2);

            ans = Math.max(optionA, optionB);
        }

        return ans;
    }
}