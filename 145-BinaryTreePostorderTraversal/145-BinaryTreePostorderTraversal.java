// Last updated: 22/05/2026, 11:25:14
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void helper(TreeNode root, List<Integer> r){
        if(root != null){
            helper(root.left, r);
            helper(root.right, r);
            r.add(root.val);
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        helper(root, lst);
        return lst;
    }
}