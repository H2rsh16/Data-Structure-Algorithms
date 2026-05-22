// Last updated: 22/05/2026, 11:18:59
class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int i = 0;
        Set<Integer> visited = new HashSet<>();

        while (i >= 0 && i < instructions.length) {
            if (visited.contains(i)) {
                break;
            }

            visited.add(i);

            if (instructions[i].equals("add")) {
                score += values[i];
                i++;
            } else if (instructions[i].equals("jump")) {
                i += values[i];
            } else {
                throw new IllegalArgumentException("Unknown instruction: " + instructions[i]);
            }
        }

        return score;
    }
}