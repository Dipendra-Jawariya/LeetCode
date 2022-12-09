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
    int maxDiff =0;
    private int findMaxDiff(TreeNode root, int maxAncestor,int minAncestor){
        if(root==null){
            return 0;
        }
        maxDiff=Math.max(maxDiff,Math.max(Math.abs(root.val - maxAncestor),Math.abs(root.val - minAncestor)));
        if(root.val > maxAncestor) maxAncestor = root.val;
        if(root.val <minAncestor) minAncestor = root.val;
        findMaxDiff(root.left,maxAncestor,minAncestor);
        findMaxDiff(root.right,maxAncestor,minAncestor);
        return maxDiff;
    }
    public int maxAncestorDiff(TreeNode root) {
        return findMaxDiff(root,root.val,root.val);
    }
}