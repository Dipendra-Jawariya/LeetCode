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
    private boolean isLeaf(TreeNode node){
        return (node.left == null) && (node.right == null);
    }
    private void findRoot(TreeNode root,List<Integer> tree){
//         preorder traversal
        if(isLeaf(root) == true){
            tree.add(root.val);
        }
        if(root.left !=null){
            findRoot(root.left,tree);
        }
        if(root.right!=null){
            findRoot(root.right,tree);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> tree1 = new ArrayList<>();
        ArrayList<Integer> tree2 = new ArrayList<>();
        findRoot(root1,tree1);
        findRoot(root2,tree2);
        return tree1.equals(tree2);
    }
}