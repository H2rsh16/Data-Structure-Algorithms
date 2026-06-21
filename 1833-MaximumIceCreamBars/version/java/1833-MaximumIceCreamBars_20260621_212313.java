// Last updated: 21/06/2026, 21:23:13
1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        
4        int max = 0;
5
6        for (int cost : costs) {
7            max = Math.max(max, cost);
8        }
9
10        int[] count = new int[max + 1];
11
12        for (int cost : costs) {
13            count[cost]++;
14        }
15
16        int result = 0;
17
18        for (int price = 1; price <= max; price++) {
19            while (count[price] > 0 && coins >= price) {
20                coins -= price;
21                result++;
22                count[price]--;
23            }
24        }
25
26        return result;
27    }
28}