// Last updated: 22/05/2026, 11:22:19
class Solution {
    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for (int n : nums) {
            int count = 0;
            int sum = 0;

            for (int d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    int other = n / d;

                    if (d == other) {
                        count++;
                        sum += d;
                    } else {
                        count += 2;
                        sum += d + other;
                    }

                    if (count > 4) break;
                }
            }

            if (count == 4) {
                result += sum;
            }
        }
        return result;
    }
}
