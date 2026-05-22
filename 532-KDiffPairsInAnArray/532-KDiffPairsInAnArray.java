// Last updated: 22/05/2026, 11:23:46
class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;
        for (int num : freqMap.keySet()) {
            if (k == 0) {
                if (freqMap.get(num) > 1) {
                    count++;
                }
            } else {
                if (freqMap.containsKey(num + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}