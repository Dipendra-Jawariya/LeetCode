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
    int findSize(ListNode* head) {
        int count = 0;
        while(head != NULL) {
            count++;
            head = head -> next;
        }
        return count;
    }
public:
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        int size = findSize(head);
        int width = size / k , extra = size % k;
        
        vector<ListNode*> ans(k);
        
        ListNode* tail = nullptr;
        for(int i = 0; i < k && head != NULL; i++) {
            ans[i] = head;
            for(int j = 0; j < width + (extra > 0); j++) {
                tail = head;
                head = head -> next;
            }
            tail -> next = nullptr;
            extra--;
        }
        return ans;
    }
};