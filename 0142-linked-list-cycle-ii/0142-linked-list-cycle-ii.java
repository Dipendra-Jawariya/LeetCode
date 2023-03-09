/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private ListNode hasCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return slow;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        
        ListNode colloidal_point = hasCycle(head);
        if(colloidal_point == null) {
            return null;
        }
        ListNode entry = head;
        while(entry != colloidal_point) {
            entry = entry.next;
            colloidal_point = colloidal_point.next;
        }
        return entry;
    }
}