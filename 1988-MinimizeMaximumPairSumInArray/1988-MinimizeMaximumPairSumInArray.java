// Last updated: 22/05/2026, 11:20:44
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int sum = nums[left] + nums[right];
            max = Math.max(max, sum);
            left++;
            right--;
        }

        return max;
    }
}