class Solution {
public:
    string removeOuterParentheses(string s) {
        string res = "";
        stack<char> st;
        
        for(int i = 0; i < s.size(); i++) {
            char ch = s[i];
            if(ch == '(') {
                if(!st.empty()) {
                    res += ch;
                }
                st.push(ch);
            } else {
                st.pop();
                if(!st.empty()) {
                    res += ch;
                }
            }
        }
        return res;
    }
};