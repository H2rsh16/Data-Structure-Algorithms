// Last updated: 22/05/2026, 11:23:31
class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;

        if(n < 3) return 0;

        Arrays.sort(nums);
        int count = 0;

        for(int i = n - 1; i >= 2; i--){
            int a = 0;
            int b = i - 1;

            while(a < b){
                if(nums[a] + nums[b] > nums[i]){
                    count += b - a;
                    b--;
                }
                else{
                    a++;
                }
            }
        }

        return count;
    }
}