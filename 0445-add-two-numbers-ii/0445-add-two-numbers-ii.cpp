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
private:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = NULL;
        while(head) {
            ListNode* temp = head->next;
            head->next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* r1 = reverseList(l1);
        ListNode* r2 = reverseList(l2);
        
        int totalSum = 0;
        int carry = 0;
        ListNode* ans = new ListNode();
        while(r1 || r2) {
            if(r1) {
                totalSum += r1 -> val;
                r1 = r1->next;
            }
            if(r2) {
                totalSum += r2 -> val;
                r2 = r2->next;
            }
            ans->val = totalSum % 10;
            carry = totalSum / 10;
            ListNode* head = new ListNode(carry);
            head->next = ans; // pointing to answer
            ans = head; // moving answer to the head
            totalSum = carry;
            
        }
         return carry == 0 ? ans->next : ans;
    }
};