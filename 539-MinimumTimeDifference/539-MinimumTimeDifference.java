// Last updated: 22/05/2026, 11:23:44
class Solution {
    public int findMinDifference(List<String> timePoints) {
                int diff = Integer.MAX_VALUE;
        int[] min = new int[timePoints.size()];

        for (int i = 0; i < min.length; i++) {
            String t = timePoints.get(i);
            int h = Integer.parseInt(t.substring(0, 2));
            int m = Integer.parseInt(t.substring(3));

            min[i] = h * 60 + m;
        }

        Arrays.sort(min);

        for (int i = 0; i < min.length - 1; i++) {
            diff = Math.min(diff, min[i + 1] - min[i]);
        }

        return Math.min(diff, 24 * 60 - min[min.length - 1] + min[0]);
    }
}