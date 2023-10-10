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
        if(cnt == n) {
            return head -> next;
        }
        int del = cnt - n - 1;
        curr = head;
        while(del-- > 0) {
            head = head -> next;
        }
        head -> next = head -> next -> next;
        return curr;
    }
};