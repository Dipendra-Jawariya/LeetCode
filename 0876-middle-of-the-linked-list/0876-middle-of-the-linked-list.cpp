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
    ListNode* middleNode(ListNode* head) {
        // find size of the linked list 
        // go to half the length of the list
        // return the answer
        
        ListNode*  curr = head;
        int cnt = 0;
        while(curr != NULL) {
            curr = curr -> next;
            cnt++;
        }
        int half = (cnt % 2 != 0) ? (cnt / 2):( (cnt+1) / 2 );
        while( half-- > 0) {
            head = head -> next;
        }
        return head;
    }
};