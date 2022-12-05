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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next ==null) return null;
        if(head.next.next == null){ 
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow.val = slow.next.val;
        // slow.next = slow.next.next;
       ListNode del= slow.next;
        slow.val = del.val;
        slow.next = slow.next.next;
        del = null;
        return head;
    }
}