/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    bool isLeaf(TreeNode* node) {
    return node -> left == nullptr && node -> right == nullptr;
}
private:
    void traverse(TreeNode* node, vector<int> &arr) {
        if(node == nullptr) return;
        traverse(node -> left,arr);
        if(isLeaf(node)) {
            arr.push_back(node->val);
        }
        traverse(node ->right, arr);
    }
public:
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> first;
        vector<int> second;
        
        traverse(root1,first);
        traverse(root2,second);
        int n = first.size();
        if(n != second.size()) return false;
        for(int i = 0; i < n; i++) {
            if(first[i] != second[i]) return false;
        }
        return true;
    }
};