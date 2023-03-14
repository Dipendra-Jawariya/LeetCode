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
    private int preorderTraversal(TreeNode node,int sum,int pointer) {
        pointer =(pointer * 10)+ node.val;
        if(node.left == null && node.right == null) {
            return pointer;
        }
        int left = 0;
        int right = 0;
        if(node.left != null) {
            left = preorderTraversal(node.left,sum,pointer);
        }
        if(node.right != null) {
            right = preorderTraversal(node.right,sum,pointer);
        }
        return left + right;
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return preorderTraversal(root,0,0);
    }
}