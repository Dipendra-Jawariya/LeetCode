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
    void f(TreeNode* root, string &str) {
        if(root == NULL) {
            return;
        }
        str += to_string(root -> val);
        // left call
        if(root -> left || root -> right) {
            str += '(';
            f(root -> left, str);
            str += ')';
        }
        // right call
        if(root -> right) {
            str += '(';
            f(root -> right, str);
            str += ')';
        }
    }
public:
    string tree2str(TreeNode* root) {
        string str = "";
        f(root,str);
        return str;
    }
};