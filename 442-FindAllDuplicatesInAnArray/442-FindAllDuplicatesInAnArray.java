// Last updated: 22/05/2026, 11:24:01
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> lst = new ArrayList<>();

        if(nums.length == 1) return lst;

        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]){
                lst.add(nums[i - 1]);
            }
        }

        return lst;
    }
}