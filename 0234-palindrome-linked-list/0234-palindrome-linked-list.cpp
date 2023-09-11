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
    ListNode* findMiddle(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast -> next && fast -> next -> next) {
            fast = fast -> next -> next;
            slow = slow -> next;
            
        }
        return slow;
    }
private:
    ListNode* reverseList(ListNode* head) {
        ListNode* curr = head;
        ListNode* prev = NULL;
        while(curr != NULL) {
            ListNode* next = curr -> next;
            curr -> next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
public:
    bool isPalindrome(ListNode* head) {
        
        if(head == NULL && head -> next == NULL) {
            return true;
         }
        
        ListNode* middle = findMiddle(head);
        ListNode* reverse = reverseList(middle -> next);
        middle -> next = NULL;
        
        ListNode* firstHalf = head;
        ListNode* secondHalf = reverse;
        
        while(secondHalf != NULL) {
            if(firstHalf -> val != secondHalf -> val) {
                return false;
            }
            
            firstHalf = firstHalf -> next;
            secondHalf = secondHalf -> next;
        }
        return true;
    }
};