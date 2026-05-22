// Last updated: 22/05/2026, 11:20:32
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalRolls = n + m;
        int totalSum = mean * totalRolls;
        int sumOfGivenRolls = 0;

        for (int roll : rolls) {
            sumOfGivenRolls += roll;
        }

        int missingSum = totalSum - sumOfGivenRolls;

        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];
        }

        int[] missingRolls = new int[n];
        Arrays.fill(missingRolls, 1);
        missingSum -= n;

        for (int i = 0; i < n && missingSum > 0; i++) {
            int add = Math.min(5, missingSum);
            missingRolls[i] += add;
            missingSum -= add;
        }

        return missingRolls;
    }
}