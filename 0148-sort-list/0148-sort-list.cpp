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
    ListNode* middle(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast -> next && fast -> next -> next) {
            slow = slow -> next;
            fast = fast -> next -> next;
            
        }
        return slow;
    }
private:
    ListNode* mergeList(ListNode* left , ListNode* right) {
        if(left == NULL || right == NULL) {
            return (left == NULL) ? right : left;
        }
        
        ListNode * ans = new ListNode(0);
        ListNode* curr = ans;
        while(left != NULL && right != NULL) {
            if(left -> val < right -> val) {
                curr -> next = left;
                left = left -> next;
            }else {
                curr -> next = right;
                right = right -> next;
            }
            curr = curr -> next;
        }
        while(left != NULL) {
            curr -> next = left ;
            curr = curr -> next;
            left = left -> next;
        }
        while(right != NULL) {
            curr -> next = right;
            curr = curr -> next;
            right = right -> next;
        }
        return ans -> next;
    }
public:
    ListNode* sortList(ListNode* head) {
        if(head == NULL || head -> next == NULL) {
            return head;
        }
        
        ListNode* newHead = head;
        ListNode* mid = middle(head);
        newHead = mid -> next;
        mid -> next = NULL;
        ListNode* left = sortList(head);
        ListNode* right = sortList(newHead);
        
        return mergeList(left, right);
    }
};