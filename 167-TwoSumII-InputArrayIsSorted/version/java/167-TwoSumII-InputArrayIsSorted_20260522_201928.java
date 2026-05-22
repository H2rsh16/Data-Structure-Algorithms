// Last updated: 22/05/2026, 20:19:28
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int n = numbers.length;
4
5        int i = 0;
6        int j = n - 1;
7
8        while(i < j){
9            int sum = numbers[i] + numbers[j];
10
11            if(sum == target){
12                return new int[]{i + 1, j + 1};
13            }
14            else if(sum > target){
15                j--;
16            }
17            else if(sum < target){
18                i++;
19            }
20            else{
21                i++;
22                j--;
23            }
24        }
25
26        return new int[]{-1, -1};
27    }
28}