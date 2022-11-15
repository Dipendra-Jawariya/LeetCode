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
    private int count(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = count(root.left);
        int rh = count(root.right);
        return 1 + lh + rh;
    }
    public int countNodes(TreeNode root) {
        return count(root);
    }
}