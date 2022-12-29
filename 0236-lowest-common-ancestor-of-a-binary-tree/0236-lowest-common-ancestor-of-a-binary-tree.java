/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean getPath(TreeNode root,List<TreeNode> arr, int x){
        if(root== null) return false;
        arr.add(root);
        if(root.val == x) return true;
        if(getPath(root.left,arr,x) || getPath(root.right,arr,x)) {
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        List<TreeNode> arr1 = new ArrayList<TreeNode>();
        List<TreeNode> arr2 = new ArrayList<TreeNode>();
        getPath(root,arr1,p.val);
        getPath(root,arr2,q.val);
        int i =0;
        while(true){
            if(i >= arr1.size() || i >= arr2.size()) return res;
            if(arr1.get(i).val != arr2.get(i).val){
                return res;
            }
            res  = arr1.get(i);
            i++;
        }
    }
}