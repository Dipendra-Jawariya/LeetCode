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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                List<Integer> row1 = new ArrayList<>();

                while (!s1.isEmpty()) {
                    TreeNode curr = s1.pop();
                    row1.add(curr.val);
                    System.out.print(curr.val + " ");
                    if (curr.left != null) {
                        s2.add(curr.left);
                    }
                    if (curr.right != null) {
                        s2.add(curr.right);
                    }
                }
                result.add(row1);
            }
            if (!s2.isEmpty()) {
                List<Integer> row2 = new ArrayList<>();

                while (!s2.isEmpty()) {
                    TreeNode curr = s2.pop();
                    row2.add(curr.val);
                    System.out.print(curr.val + " ");
                    if (curr.right != null) {
                        s1.add(curr.right);
                    }
                    if (curr.left != null) {
                        s1.add(curr.left);
                    }
                }
                result.add(row2);
            }
        }
        return result;
    }
}
