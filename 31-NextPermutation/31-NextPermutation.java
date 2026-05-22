// Last updated: 22/05/2026, 11:26:24
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while(i >= 0 && nums[i] >= nums[i + 1]) i--;

        if(i >= 0){
            int j = n - 1;

            while(nums[j] <= nums[i]) j--;

            swap(nums, i, j);
        }

        for(int l = i + 1, r = n - 1; l < r; l++, r--){
            swap(nums, l, r);
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}