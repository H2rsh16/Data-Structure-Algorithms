// Last updated: 22/05/2026, 11:23:52
class Solution {
    public int binarySearch(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++){
            int idx = binarySearch(nums2, nums1[i]);

            arr[i] = -1;

            for(int j = idx + 1; j < nums2.length; j++){
                if(nums2[j] > nums1[i]){
                    arr[i] = nums2[j];
                    break;
                }
            }
        }
        return arr;
    }
}