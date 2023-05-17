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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode curr = head,prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public int pairSum(ListNode head) {
        // if(head == null ) return 0;
        ListNode middle = findMiddle(head);
        ListNode reverse = reverseList(middle);
        int twin_sum = 0;
        while(reverse != null) {
            twin_sum = Math.max(twin_sum , head.val + reverse.val);
            head = head.next;
            reverse = reverse.next;
        }
        return twin_sum;
    }
}