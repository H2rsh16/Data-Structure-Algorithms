// Last updated: 23/09/2026, 22:16:23
1class Solution {
2    public int minOperations(int[] nums, int x) {
3
4        int totalSum = 0;
5
6        for (int num : nums) {
7            totalSum += num;
8        }
9
10        int target = totalSum - x;
11
12        if (target < 0) {
13            return -1;
14        }
15
16        if (target == 0) {
17            return nums.length;
18        }
19
20        int left = 0;
21        int sum = 0;
22        int maxLength = -1;
23
24        for (int right = 0; right < nums.length; right++) {
25
26            sum += nums[right];
27
28            while (sum > target) {
29                sum -= nums[left];
30                left++;
31            }
32
33            if (sum == target) {
34                maxLength = Math.max(
35                    maxLength,
36                    right - left + 1
37                );
38            }
39        }
40
41        if (maxLength == -1) {
42            return -1;
43        }
44
45        return nums.length - maxLength;
46    }
47}