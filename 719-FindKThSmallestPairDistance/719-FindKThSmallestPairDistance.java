// Last updated: 22/05/2026, 11:23:14
class Solution {
    public boolean SmallestPair(int[] nums, int k, int m){
        int count = 0;
        int n = nums.length;
        int l = 0;

        for(int r = 1; r < n; r++){
            while(nums[r] - nums[l] > m){
                l++;
            }
            count += r - l;
        }

        return (count >= k);
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];

        while(l < r){
            int m = (l + r) / 2;

            if(SmallestPair(nums, k, m)){
                r = m;
            }
            else{
                l = m + 1;
            }
        }

        return l;
    }
}