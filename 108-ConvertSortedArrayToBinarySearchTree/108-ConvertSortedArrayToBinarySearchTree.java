// Last updated: 22/05/2026, 11:25:34
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
    public TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }

        int m = (start + end) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, start, m - 1);
        root.right = helper(nums, m + 1, end);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}