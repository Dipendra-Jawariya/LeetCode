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
int findSize(ListNode* head) {
    int cnt = 0;
    while(head != NULL) {
        cnt++;
        head = head -> next;
    }
    return cnt;
}
public:
    ListNode* deleteMiddle(ListNode* head) {
        if(head -> next == NULL) return NULL;
        // if(head == NULL || head -> next == NULL) return NULL;
        int size = findSize(head);
        int middle = size / 2;
        // if(size % 2 == 0) {
        //     middle = (size / 2) +1;
        // } else {
        //     middle = size / 2;
        // }
        ListNode* curr = head;
        for(int i = 0; i < middle - 1; i++) {
            curr = curr -> next;
        }
        curr -> next = curr -> next -> next;
        return head;
    }
};