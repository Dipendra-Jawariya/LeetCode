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
    List<TreeNode> ans = new LinkedList<>();
    Map<String ,Integer> map = new HashMap<>();
    
    private String dfs(TreeNode root) {
        String s1  = " ";
        String s2 = " ";
        String curr = String.valueOf(root.val);
        if(root.left != null) {
            s1 = dfs(root.left);
        }
        if(root.right !=null) {
             s2 = dfs(root.right);
        }
        String t = curr + "l" + s1 + "r" + s2;
        map.put(t,map.getOrDefault(t,0) +1);
        
        if(map.get(t) == 2) {
            ans.add(root);
        }
        return t;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }
}
