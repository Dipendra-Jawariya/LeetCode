/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private TreeNode solve(int low,int high,ArrayList<TreeNode> ls) {
        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode root = ls.get(mid) ;
        root.left = solve(low,mid-1,ls);
        root.right = solve(mid+1,high,ls);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<TreeNode> ls = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            ls.add(new TreeNode(curr.val));
            curr = curr.next;
        }
        return solve(0,ls.size()-1,ls);
    }
}