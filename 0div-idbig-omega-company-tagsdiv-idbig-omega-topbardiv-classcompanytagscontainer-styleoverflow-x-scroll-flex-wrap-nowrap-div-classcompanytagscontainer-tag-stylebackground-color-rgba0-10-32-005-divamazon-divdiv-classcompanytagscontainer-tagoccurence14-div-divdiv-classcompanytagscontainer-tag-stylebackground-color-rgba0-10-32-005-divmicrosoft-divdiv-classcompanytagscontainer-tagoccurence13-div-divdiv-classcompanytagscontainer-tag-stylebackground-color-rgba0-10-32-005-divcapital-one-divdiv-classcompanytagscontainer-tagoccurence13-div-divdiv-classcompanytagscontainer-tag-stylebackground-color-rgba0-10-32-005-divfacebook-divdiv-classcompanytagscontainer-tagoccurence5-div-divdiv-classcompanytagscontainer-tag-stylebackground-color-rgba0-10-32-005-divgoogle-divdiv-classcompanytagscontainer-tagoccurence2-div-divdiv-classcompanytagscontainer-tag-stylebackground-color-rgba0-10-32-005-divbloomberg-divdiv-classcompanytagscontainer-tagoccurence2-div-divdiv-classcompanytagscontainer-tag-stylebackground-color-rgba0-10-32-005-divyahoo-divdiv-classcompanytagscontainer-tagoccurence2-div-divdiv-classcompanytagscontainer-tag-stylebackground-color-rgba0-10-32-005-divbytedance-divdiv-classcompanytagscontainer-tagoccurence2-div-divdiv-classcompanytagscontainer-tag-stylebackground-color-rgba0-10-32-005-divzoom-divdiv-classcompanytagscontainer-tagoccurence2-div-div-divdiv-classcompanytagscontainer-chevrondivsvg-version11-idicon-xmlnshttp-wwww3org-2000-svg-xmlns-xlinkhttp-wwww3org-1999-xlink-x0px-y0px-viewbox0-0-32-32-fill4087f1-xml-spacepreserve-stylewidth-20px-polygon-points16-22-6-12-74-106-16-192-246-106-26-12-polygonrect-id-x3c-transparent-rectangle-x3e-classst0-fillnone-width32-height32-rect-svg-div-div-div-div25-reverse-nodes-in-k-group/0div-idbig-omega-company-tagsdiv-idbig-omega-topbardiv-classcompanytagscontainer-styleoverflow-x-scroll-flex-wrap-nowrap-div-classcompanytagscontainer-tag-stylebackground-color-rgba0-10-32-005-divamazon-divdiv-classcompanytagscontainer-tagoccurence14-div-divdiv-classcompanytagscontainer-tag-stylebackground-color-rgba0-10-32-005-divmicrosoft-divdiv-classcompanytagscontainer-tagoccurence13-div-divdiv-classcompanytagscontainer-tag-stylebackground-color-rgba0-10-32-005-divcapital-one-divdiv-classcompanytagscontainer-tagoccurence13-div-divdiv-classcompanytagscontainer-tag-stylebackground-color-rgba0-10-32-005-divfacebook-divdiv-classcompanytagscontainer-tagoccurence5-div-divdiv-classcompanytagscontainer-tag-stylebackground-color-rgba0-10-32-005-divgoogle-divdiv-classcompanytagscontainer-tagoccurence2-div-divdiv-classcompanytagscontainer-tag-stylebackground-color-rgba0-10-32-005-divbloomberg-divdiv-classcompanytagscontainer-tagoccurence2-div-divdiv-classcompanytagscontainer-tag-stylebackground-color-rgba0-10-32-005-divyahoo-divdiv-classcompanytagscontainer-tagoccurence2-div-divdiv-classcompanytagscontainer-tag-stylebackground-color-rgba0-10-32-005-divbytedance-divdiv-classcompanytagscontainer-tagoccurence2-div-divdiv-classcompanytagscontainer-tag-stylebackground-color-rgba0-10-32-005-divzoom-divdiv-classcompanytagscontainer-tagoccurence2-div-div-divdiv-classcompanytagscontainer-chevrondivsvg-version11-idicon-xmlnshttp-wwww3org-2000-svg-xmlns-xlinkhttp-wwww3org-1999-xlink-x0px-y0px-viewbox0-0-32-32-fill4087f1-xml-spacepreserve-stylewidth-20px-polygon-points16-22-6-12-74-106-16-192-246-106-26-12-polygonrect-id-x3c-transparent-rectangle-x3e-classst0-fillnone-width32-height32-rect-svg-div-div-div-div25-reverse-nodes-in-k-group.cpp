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
    ListNode* reverse(ListNode* head) {
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

private:
    ListNode* findkthNode(ListNode* head,int k) {
        k--;
        while(head != NULL && k > 0) {
            k--;
            head = head -> next;
        }
        return head;
    }
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* temp = head;
        
        ListNode* prevNode = NULL;
        // Traverse through the list
        while(temp != NULL) {
            ListNode* kthNode = findkthNode(temp,k); // get the kth node
            if(kthNode == NULL) {
                if(prevNode) prevNode -> next = temp;
                break;
            } 
            ListNode* nextNode = kthNode -> next; // store the next node 
            kthNode -> next = NULL;
            reverse(temp);  
            
            if(temp == head) {
                head = kthNode;
            } else {
                prevNode -> next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
};