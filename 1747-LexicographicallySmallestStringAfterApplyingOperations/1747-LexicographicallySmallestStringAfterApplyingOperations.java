// Last updated: 22/05/2026, 11:21:18
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String result = s;

        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(result) < 0) {
                result = curr;
            }

            String added = addToOddIndices(curr, a);
            if (visited.add(added)) {
                queue.offer(added);
            }

            String rotated = rotateRight(curr, b);
            if (visited.add(rotated)) {
                queue.offer(rotated);
            }
        }

        return result;
    }

    private String addToOddIndices(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            int digit = (chars[i] - '0' + a) % 10;
            chars[i] = (char) (digit + '0');
        }
        return new String(chars);
    }

    private String rotateRight(String s, int b) {
        int n = s.length();
        b = b % n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}