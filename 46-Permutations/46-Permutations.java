// Last updated: 22/05/2026, 11:26:10
class Solution {
    public void helper(int[] nums, List<List<Integer>> ans, int i){
        if(i >= nums.length){
            ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int j = i; j < nums.length; j++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            helper(nums, ans, i + 1);

            int temp2 = nums[i];
            nums[i] = nums[j];
            nums[j] = temp2;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();

        int idx = 0;

        helper(nums, lst, idx);
        return lst;
    }
}