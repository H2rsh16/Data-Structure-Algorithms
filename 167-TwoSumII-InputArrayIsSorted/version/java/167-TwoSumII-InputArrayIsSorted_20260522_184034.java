// Last updated: 22/05/2026, 18:40:34
1class Solution {
2    public int[] twoSum(int[] numbers, int target) {
3        int n = numbers.length;
4        int left = 0;
5        int right = n - 1;
6
7        while(left < right){
8            int sum = numbers[left] + numbers[right];
9
10            if(sum == target){
11                return new int[]{left + 1, right + 1};
12            }
13            else if(sum > target){
14                right--;
15            }
16            else if(sum < target){
17                left++;
18            }
19            else{
20                left++;
21                right--;
22            }
23        }
24
25        return new int[] {-1, -1};
26    }
27}