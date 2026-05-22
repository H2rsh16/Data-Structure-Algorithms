// Last updated: 22/05/2026, 11:25:39
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
    private List<Integer> traverse(TreeNode root, List<Integer> list){
        if(root == null){
            return list;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();

        return traverse(root, lst);
    }
}