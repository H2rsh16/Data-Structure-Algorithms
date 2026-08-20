// Last updated: 20/08/2026, 07:48:57
1class Solution {
2    public int[] resultArray(int[] nums) {
3        List<Integer> arr1 = new ArrayList<>();
4        List<Integer> arr2 = new ArrayList<>();
5        
6        arr1.add(nums[0]);
7        arr2.add(nums[1]);
8        
9        for (int i = 2; i < nums.length; i++) {
10            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
11                arr1.add(nums[i]);
12            } else {
13                arr2.add(nums[i]);
14            }
15        }
16        
17        int[] result = new int[nums.length];
18        int idx = 0;
19        for (int num : arr1) result[idx++] = num;
20        for (int num : arr2) result[idx++] = num;
21        
22        return result;
23    }
24}