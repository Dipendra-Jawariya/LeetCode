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
    private void inOrder(TreeNode root,ArrayList<Integer> ls){
        if(root != null){
            inOrder(root.left,ls);
            ls.add(root.val);
            inOrder(root.right,ls);
        }
    }
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        inOrder(root,ls);
        int mini = (int) 1e9;
        for(int i = 0; i < ls.size() - 1; i++) {
            int diff = Math.abs(ls.get(i) - ls.get(i+1));
            mini = Math.min(diff,mini);
        }
        return mini;
    }
}