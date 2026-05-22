// Last updated: 22/05/2026, 11:19:53
class Solution {
    public int maximumCount(int[] nums) {
        if (nums.length == 0) return 0;

        int neg = binarySearch(nums, 0);
        int pos = nums.length - binarySearch(nums, 1);

        return Math.max(pos, neg);
    }

    public static int binarySearch(int[] arr, int target){
        int i = 0, j = arr.length - 1, result = arr.length;

        while(i <= j){
            int mid = i + (j - i) / 2;
            if(arr[mid] < target){
                i = mid + 1;
            }
            else{
                result = mid;
                j = mid - 1;
            }
        }

        return result;
    }
}