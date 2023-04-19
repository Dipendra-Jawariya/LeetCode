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
    int pathLength = 0;
    private void dfs(TreeNode node, boolean goLeft,int steps) {
        if(node == null) {
            return;
        }
        pathLength = Math.max(steps,pathLength);
        if(goLeft) {
            dfs(node.left,false,steps+1);
            dfs(node.right,true,1);
        } else {
            dfs(node.left,false,1);
            dfs(node.right,true,steps+1);
        }
    }
    public int longestZigZag(TreeNode root) {
        dfs(root,false,0);
        dfs(root,true,0);
        return pathLength;
    }
}