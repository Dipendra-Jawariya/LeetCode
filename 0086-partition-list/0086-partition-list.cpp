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
    ListNode* partition(ListNode* head, int x) {
        if(!head) return head;
        
        ListNode* dummy1 = new ListNode(0);
        ListNode* temp1 = dummy1;
        
        ListNode* dummy2 = new ListNode(0);
        ListNode* temp2 = dummy2;
        
        ListNode* curr = head;
        
        while(curr != NULL) {
            if(curr->val < x) {
                temp1->next = new ListNode(curr->val);
                temp1 = temp1 -> next;
            } else {
                temp2 -> next = new ListNode(curr->val);
                temp2 = temp2 -> next;
            }
            curr = curr -> next;
        }
        temp1 -> next = dummy2->next;
        return dummy1->next;
    }
};