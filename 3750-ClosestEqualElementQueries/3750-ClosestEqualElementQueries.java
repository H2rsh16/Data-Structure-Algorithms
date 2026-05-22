// Last updated: 22/05/2026, 11:18:53
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);
            
            if (list.size() == 1) {
                result.add(-1);
                continue;
            }
            
            int pos = Collections.binarySearch(list, q);
            
            int leftIdx = (pos - 1 + list.size()) % list.size();
            int rightIdx = (pos + 1) % list.size();
            
            int left = list.get(leftIdx);
            int right = list.get(rightIdx);
            
            int distLeft = Math.min(Math.abs(q - left), n - Math.abs(q - left));
            int distRight = Math.min(Math.abs(q - right), n - Math.abs(q - right));
            
            result.add(Math.min(distLeft, distRight));
        }
        
        return result;
    }
}