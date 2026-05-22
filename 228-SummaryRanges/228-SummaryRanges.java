// Last updated: 22/05/2026, 11:24:36
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> lst = new ArrayList<>();
        int s = 0;
        for(int i = 1; i <= nums.length; i++){
            if(i == nums.length || nums[i] != nums[i - 1] + 1){
                if(s == i - 1){
                    lst.add(String.valueOf(nums[s]));
                }
                else{
                    lst.add(nums[s] + "->" + nums[i - 1]);
                }
                s = i;
            }

        }
        return lst;
    }
}