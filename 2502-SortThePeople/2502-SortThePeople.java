// Last updated: 22/05/2026, 11:20:03
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        Map<Integer, String> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            m.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String sorted[] = new String[n];

        for (int i = n - 1; i >= 0; i--) {
            sorted[n - i - 1] = m.get(heights[i]);
        }

        return sorted;
    }
}