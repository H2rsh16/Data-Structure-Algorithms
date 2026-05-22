// Last updated: 22/05/2026, 11:20:30
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for(int a: nums1){
            set1.add(a);
        }
        for(int a: nums2){
            set2.add(a);
        }
        for(int a: nums3){
            set3.add(a);
        }

        Set<Integer> result = new HashSet<>();

        for(int a: set1){
            if(set2.contains(a) || set3.contains(a)){
                result.add(a);
            }
        }
        for(int a: set2){
            if(set3.contains(a)){
                result.add(a);
            }
        }

        return new ArrayList<>(result);
    }
}