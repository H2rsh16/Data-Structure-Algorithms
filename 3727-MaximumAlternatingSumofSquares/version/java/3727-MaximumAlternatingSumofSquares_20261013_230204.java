// Last updated: 13/10/2026, 23:02:04
1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        Integer[] arr = new Integer[nums.length];
4
5        for (int i = 0; i < nums.length; i++) {
6            arr[i] = nums[i];
7        }
8
9        Arrays.sort(arr, (a, b) ->
10            Long.compare(Math.abs((long) b), Math.abs((long) a))
11        );
12
13        long sum = 0;
14        int n = arr.length;
15
16        for (int i = 0; i < n; i++) {
17            long square = (long) arr[i] * arr[i];
18
19            if (i < (n + 1) / 2) {
20                sum += square;
21            } else {
22                sum -= square;
23            }
24        }
25
26        return sum;
27    }
28}