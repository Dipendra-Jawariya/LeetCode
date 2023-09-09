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
    ListNode* recursionReverse(ListNode* head, ListNode* prev) {
        if(head == NULL) {
            return prev;
        }
        while(head != NULL) {
            ListNode* next = head -> next;
            head -> next = prev;
            recursionReverse(next , head);
        }
        return head;
    }
public:
    ListNode* reverseList(ListNode* head) {
        
        ListNode* prev = nullptr;
        while(head != NULL){
            ListNode* next = head -> next;
            head -> next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
};