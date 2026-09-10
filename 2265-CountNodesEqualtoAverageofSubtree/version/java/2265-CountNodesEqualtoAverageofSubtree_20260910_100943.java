// Last updated: 10/09/2026, 10:09:43
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    int ans = 0;
18    public int averageOfSubtree(TreeNode root) {
19        dfs(root);
20        return ans;
21    }
22
23    public int[] dfs(TreeNode root){
24        if(root == null) return new int[]{0, 0};
25
26        int[] left = dfs(root.left);
27
28        int[] right = dfs(root.right);
29
30        int sum = root.val + left[0] + right[0];
31        int count = 1 + left[1] + right[1];
32
33        int avg = sum / count;
34
35        if(root.val == avg){
36            ans++;
37        }
38
39        return new int[]{sum, count};
40    }
41}