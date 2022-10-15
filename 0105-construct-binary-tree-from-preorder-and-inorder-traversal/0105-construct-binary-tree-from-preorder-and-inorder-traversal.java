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
    int preIndex=0;
    public TreeNode cTree(int preorder[],int inorder[],int is,int ie){
        if(is>ie){
            return null;
        }
        TreeNode root =new TreeNode(preorder[preIndex++]);
                int index=0;
                for(int i =0;i<inorder.length;i++){
                    if(inorder[i]==root.val){
                        index  = i;
                        break;
                    }
                }
                root.left = cTree(preorder,inorder,is,index-1);
                root.right = cTree(preorder,inorder,index+1,ie);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return cTree(preorder,inorder,0,inorder.length-1);
    }
    
}