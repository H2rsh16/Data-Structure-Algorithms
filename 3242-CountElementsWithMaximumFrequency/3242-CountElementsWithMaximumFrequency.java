// Last updated: 22/05/2026, 11:19:20
class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        int totalFreq = 0;

        for (int num : nums) {
            int freq = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, freq);

            if (freq > maxFrequency) {
                maxFrequency = freq;
                totalFreq = freq;
            } else if (freq == maxFrequency) {
                totalFreq += freq;
            }
        }

        return totalFreq;
    }
}