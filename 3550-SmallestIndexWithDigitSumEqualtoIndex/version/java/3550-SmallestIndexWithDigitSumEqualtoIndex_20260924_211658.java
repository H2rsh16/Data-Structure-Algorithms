// Last updated: 24/09/2026, 21:16:58
1class Solution {
2    public int smallestIndex(int[] nums) {
3        for (int i = 0; i < nums.length; i++) {
4            if (getDigitSum(nums[i]) == i) {
5                return i;
6            }
7        }
8        return -1;
9    }
10
11    private int getDigitSum(int n) {
12        int sum = 0;
13        while (n > 0) {
14            sum += n % 10;
15            n /= 10;
16        }
17        return sum;
18    }
19}