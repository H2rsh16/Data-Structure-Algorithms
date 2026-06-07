// Last updated: 07/06/2026, 13:05:43
1
2class Solution {
3    public TreeNode createBinaryTree(int[][] descriptions) {
4        Map<Integer, TreeNode> map = new HashMap<>();
5        Set<Integer> children = new HashSet<>();
6
7        for (int[] d : descriptions) {
8            int parentVal = d[0];
9            int childVal = d[1];
10            int isLeft = d[2];
11
12            map.putIfAbsent(parentVal, new TreeNode(parentVal));
13            map.putIfAbsent(childVal, new TreeNode(childVal));
14
15            TreeNode parent = map.get(parentVal);
16            TreeNode child = map.get(childVal);
17
18            if (isLeft == 1) {
19                parent.left = child;
20            } else {
21                parent.right = child;
22            }
23
24            children.add(childVal);
25        }
26
27        for (int[] d : descriptions) {
28            int parentVal = d[0];
29            if (!children.contains(parentVal)) {
30                return map.get(parentVal);
31            }
32        }
33
34        return null;
35    }
36}