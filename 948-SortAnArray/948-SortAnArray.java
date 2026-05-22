// Last updated: 22/05/2026, 11:22:45
class Solution {
    private void conquor(int[] nums, int si, int mid, int ei){
        int[] sorted = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid + 1;
        int k = 0;
        while(idx1 <= mid && idx2 <= ei){
            if(nums[idx1] <= nums[idx2]){
                sorted[k++] = nums[idx1++];
            }
            else{
                sorted[k++] = nums[idx2++];
            }
        }

        while(idx1 <= mid){
            sorted[k++] = nums[idx1++];
        }
        
        while(idx2 <= ei){
            sorted[k++] = nums[idx2++];
        }

        for(int i = 0, j = si; i < sorted.length; i++, j++){
            nums[j] = sorted[i];
        }
    }
    private void divide(int[] nums, int si, int ei){
        if(si >= ei){
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(nums, si, mid);
        divide(nums, mid + 1, ei);
        conquor(nums, si, mid, ei);
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        divide(nums, 0, n - 1);
        return nums;
    }
}