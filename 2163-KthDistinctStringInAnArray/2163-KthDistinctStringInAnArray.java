// Last updated: 22/05/2026, 11:20:29
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        
        List<String> distinctStrings = new ArrayList<>();
        
        for (String str : arr) {
            if (frequencyMap.get(str) == 1) {
                distinctStrings.add(str);
            }
        }
        
        if (k > 0 && k <= distinctStrings.size()) {
            return distinctStrings.get(k - 1);
        } else {
            return "";
        }
    }
}