// Last updated: 22/05/2026, 11:18:49
class Solution {
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) return false;
        }
        return true;
    }
    public int minimumPairRemoval(int[] nums) {
 List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        int operations = 0;

        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    minIndex = i;
                }
            }

            // Replace pair at minIndex with their sum
            int merged = list.get(minIndex) + list.get(minIndex + 1);
            list.remove(minIndex + 1);
            list.set(minIndex, merged);

            operations++;
        }

        return operations;
    }
}