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
        ListNode prev = null ,curr =  head;
        int count=1;
        while(count!=left){
            prev = curr;
            curr=curr.next;
            count++;
        }
        ListNode start = curr;
        while(count!=right){
            curr = curr.next;
            count++;
        }
        ListNode rest = curr.next;
        curr.next = null;
        ListNode newHead = reverse(start);
        if(prev!=null){
            prev.next = newHead;
        }
        curr =newHead;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next = rest;
        if(left==1){
            return newHead;
        }
        else{
            return head;
        }
    }
}