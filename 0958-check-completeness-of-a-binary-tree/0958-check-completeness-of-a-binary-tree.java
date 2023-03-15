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
    private int countNodes(TreeNode root) {
        if(root == null) {
             return 0;
        }
        return 1 + countNodes(root.left)  + countNodes(root.right);
    }
    private boolean checkForIndex(TreeNode root,int ind,int totalNode) {
        if(root == null) {
            return true;
        }
        
        if(ind >= totalNode) {
            return false;
        }
        return checkForIndex(root.left,2 * ind + 1,totalNode) && 
            checkForIndex(root.right,2 * ind+2,totalNode);
    }
    public boolean isCompleteTree(TreeNode root) {
         if(root == null) {
             return true;
         }
        int totalNode = countNodes(root);
        return checkForIndex(root,0,totalNode);
    }
}