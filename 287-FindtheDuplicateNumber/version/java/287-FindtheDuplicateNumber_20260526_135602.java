// Last updated: 26/05/2026, 13:56:02
1class Solution {
2    public int findDuplicate(int[] nums) {
3        int slow = nums[0];
4        int fast = nums[0];
5
6        do{
7            slow = nums[slow];
8            fast = nums[nums[fast]];
9        }
10        while(slow != fast);
11
12        slow = nums[0];
13
14        while(slow != fast){
15            slow = nums[slow];
16            fast = nums[fast];
17        }
18
19        return slow;
20    }
21}