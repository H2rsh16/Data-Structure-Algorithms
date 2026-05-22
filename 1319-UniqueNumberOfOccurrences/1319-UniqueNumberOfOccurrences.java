// Last updated: 22/05/2026, 11:22:15
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> seenFrequencies = new HashSet<>();

        for (int freq : countMap.values()) {
            if (!seenFrequencies.add(freq)) {
                return false;
            }
        }

        return true;
    }
}