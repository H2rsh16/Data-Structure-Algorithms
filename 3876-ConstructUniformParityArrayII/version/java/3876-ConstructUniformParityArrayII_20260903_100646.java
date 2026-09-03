// Last updated: 03/09/2026, 10:06:46
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int min = nums1[0];
4        boolean isOdd = false;
5        int n = nums1.length;
6
7        for(int i = 0; i < n; i++){
8            min = Math.min(min, nums1[i]);
9
10            if(nums1[i] % 2 != 0){
11                isOdd = true;
12            }
13        }
14
15        if(min % 2 != 0){
16            return true;
17        }
18
19        if(isOdd){
20            return false;
21        }
22
23        return true;
24    }
25}