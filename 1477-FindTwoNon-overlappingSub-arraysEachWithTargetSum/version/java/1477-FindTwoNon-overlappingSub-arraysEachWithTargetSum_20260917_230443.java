// Last updated: 17/09/2026, 23:04:43
1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n = arr.length;
4
5        int[] best = new int[n];
6
7        int INF = n + 1;
8        for (int i = 0; i < n; i++) {
9            best[i] = INF;
10        }
11
12        int left = 0;
13        int sum = 0;
14        int answer = INF;
15        int minLength = INF;
16
17        for (int right = 0; right < n; right++) {
18            sum += arr[right];
19
20            while (sum > target) {
21                sum -= arr[left];
22                left++;
23            }
24
25            if (sum == target) {
26                int currentLength = right - left + 1;
27
28                if (left > 0 && best[left - 1] != INF) {
29                    answer = Math.min(
30                        answer,
31                        currentLength + best[left - 1]
32                    );
33                }
34
35                minLength = Math.min(minLength, currentLength);
36            }
37
38            if (right == 0) {
39                best[right] = minLength;
40            } else {
41                best[right] = Math.min(best[right - 1], minLength);
42            }
43        }
44
45        return answer == INF ? -1 : answer;
46    }
47}