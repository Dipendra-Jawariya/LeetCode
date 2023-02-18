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
    private void swap(TreeNode cur) {
        if(cur == null) {
            return;
        }
        swap(cur.left);
        swap(cur.right);
        //Swap the child pointers
        TreeNode temp ;
        temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
    }
    public TreeNode invertTree(TreeNode root) {
            swap(root);
            return root;
        
    }
}