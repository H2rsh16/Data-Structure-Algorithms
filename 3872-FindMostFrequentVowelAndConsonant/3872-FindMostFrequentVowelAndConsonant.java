// Last updated: 22/05/2026, 11:18:38
class Solution {
    public int maxFreqSum(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int maxVowelFreq = 0;
        int maxConsonantFreq = 0;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            if (vowels.contains(ch)) {
                maxVowelFreq = Math.max(maxVowelFreq, count);
            } else {
                maxConsonantFreq = Math.max(maxConsonantFreq, count);
            }
        }

        return maxVowelFreq + maxConsonantFreq;
    }
}