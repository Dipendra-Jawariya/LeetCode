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
    public ListNode reverse(ListNode head){
        ListNode prev = null,next = null,curr=head;
        while(curr!=null){
            next= curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int count = 1;
        ListNode curr=head;
        ListNode prev = null;
        while(count!=left){
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode start = curr;
        while(count!=right){
            curr = curr.next;
            count++;
        }
        ListNode remaining = curr.next;
        curr.next = null;
        ListNode reverseList = reverse(start);
        if(prev!=null){
            prev.next = reverseList;
        }
        curr = reverseList;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next =remaining;
        if(left==1){
            return reverseList;
        }
        else{
            return head;
        }
    }
}