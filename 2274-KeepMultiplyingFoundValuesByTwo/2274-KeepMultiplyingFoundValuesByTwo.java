// Last updated: 22/05/2026, 11:20:18
class Solution {
    private int binarysearch(int[] nums, int t){
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = l + (r - l) / 2;

            if(nums[m] == t){
                return m;
            }
            else if(nums[m] < t){
                l = m + 1;
            }
            else{
                r = m - 1;
            }
        }

        return -1;
    }
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        while(binarysearch(nums, original) != -1){
           original *= 2;
        }


        return original;
    }
}