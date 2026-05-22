// Last updated: 22/05/2026, 11:22:42
class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet();

        for(int num: nums){
            if(set.contains(num)) return num;
            set.add(num);
        }

        return -1;
    }
}