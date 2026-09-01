// Last updated: 01/09/2026, 09:37:47
1class Solution {
2    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
3        int n = 0;
4
5        for(int num: candies){
6            n = Math.max(n, num);
7        }
8
9        List<Boolean> lst = new ArrayList<>();
10
11        for(int num: candies){
12            int val = num + extraCandies;
13
14            if(val >= n){
15                lst.add(true);
16            }
17            else{
18                lst.add(false);
19            }
20        }
21
22        return lst;
23    }
24}