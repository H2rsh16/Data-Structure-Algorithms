// Last updated: 22/05/2026, 11:24:04
class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;

        int n = stones.length;
        Map<Integer, Set<Integer>> jumps = new HashMap<>();

        for (int stone : stones) {
            jumps.put(stone, new HashSet<>());
        }

        jumps.get(0).add(0);

        for (int stone : stones) {
            for (int k : jumps.get(stone)) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && jumps.containsKey(stone + step)) {
                        jumps.get(stone + step).add(step);
                    }
                }
            }
        }

        return !jumps.get(stones[n - 1]).isEmpty();
    }
}