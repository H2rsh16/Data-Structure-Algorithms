// Last updated: 22/05/2026, 11:26:12
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int max = 0;
        int end  = 0;

        if (nums.length <= 1) return 0;
        
        for(int i = 0; i < nums.length; i++){

            max = Math.max(max, i + nums[i]);

            if (i == end) {
                jumps++;
                end = max;

                if (end >= nums.length - 1) break;
            }
        }

        return jumps;
    }
}