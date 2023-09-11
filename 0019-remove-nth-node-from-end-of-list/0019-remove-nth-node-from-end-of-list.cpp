/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* curr = head;
        int cnt = 0;
        while(curr != NULL) {
            cnt++;
            curr = curr -> next;
        }
        if( n == cnt) return head -> next;
        curr = head;
        for(int i = 1; i < (cnt - n) ; i++) {
            curr = curr -> next;
        }
        curr -> next = curr -> next -> next;
        return head;
    }
};