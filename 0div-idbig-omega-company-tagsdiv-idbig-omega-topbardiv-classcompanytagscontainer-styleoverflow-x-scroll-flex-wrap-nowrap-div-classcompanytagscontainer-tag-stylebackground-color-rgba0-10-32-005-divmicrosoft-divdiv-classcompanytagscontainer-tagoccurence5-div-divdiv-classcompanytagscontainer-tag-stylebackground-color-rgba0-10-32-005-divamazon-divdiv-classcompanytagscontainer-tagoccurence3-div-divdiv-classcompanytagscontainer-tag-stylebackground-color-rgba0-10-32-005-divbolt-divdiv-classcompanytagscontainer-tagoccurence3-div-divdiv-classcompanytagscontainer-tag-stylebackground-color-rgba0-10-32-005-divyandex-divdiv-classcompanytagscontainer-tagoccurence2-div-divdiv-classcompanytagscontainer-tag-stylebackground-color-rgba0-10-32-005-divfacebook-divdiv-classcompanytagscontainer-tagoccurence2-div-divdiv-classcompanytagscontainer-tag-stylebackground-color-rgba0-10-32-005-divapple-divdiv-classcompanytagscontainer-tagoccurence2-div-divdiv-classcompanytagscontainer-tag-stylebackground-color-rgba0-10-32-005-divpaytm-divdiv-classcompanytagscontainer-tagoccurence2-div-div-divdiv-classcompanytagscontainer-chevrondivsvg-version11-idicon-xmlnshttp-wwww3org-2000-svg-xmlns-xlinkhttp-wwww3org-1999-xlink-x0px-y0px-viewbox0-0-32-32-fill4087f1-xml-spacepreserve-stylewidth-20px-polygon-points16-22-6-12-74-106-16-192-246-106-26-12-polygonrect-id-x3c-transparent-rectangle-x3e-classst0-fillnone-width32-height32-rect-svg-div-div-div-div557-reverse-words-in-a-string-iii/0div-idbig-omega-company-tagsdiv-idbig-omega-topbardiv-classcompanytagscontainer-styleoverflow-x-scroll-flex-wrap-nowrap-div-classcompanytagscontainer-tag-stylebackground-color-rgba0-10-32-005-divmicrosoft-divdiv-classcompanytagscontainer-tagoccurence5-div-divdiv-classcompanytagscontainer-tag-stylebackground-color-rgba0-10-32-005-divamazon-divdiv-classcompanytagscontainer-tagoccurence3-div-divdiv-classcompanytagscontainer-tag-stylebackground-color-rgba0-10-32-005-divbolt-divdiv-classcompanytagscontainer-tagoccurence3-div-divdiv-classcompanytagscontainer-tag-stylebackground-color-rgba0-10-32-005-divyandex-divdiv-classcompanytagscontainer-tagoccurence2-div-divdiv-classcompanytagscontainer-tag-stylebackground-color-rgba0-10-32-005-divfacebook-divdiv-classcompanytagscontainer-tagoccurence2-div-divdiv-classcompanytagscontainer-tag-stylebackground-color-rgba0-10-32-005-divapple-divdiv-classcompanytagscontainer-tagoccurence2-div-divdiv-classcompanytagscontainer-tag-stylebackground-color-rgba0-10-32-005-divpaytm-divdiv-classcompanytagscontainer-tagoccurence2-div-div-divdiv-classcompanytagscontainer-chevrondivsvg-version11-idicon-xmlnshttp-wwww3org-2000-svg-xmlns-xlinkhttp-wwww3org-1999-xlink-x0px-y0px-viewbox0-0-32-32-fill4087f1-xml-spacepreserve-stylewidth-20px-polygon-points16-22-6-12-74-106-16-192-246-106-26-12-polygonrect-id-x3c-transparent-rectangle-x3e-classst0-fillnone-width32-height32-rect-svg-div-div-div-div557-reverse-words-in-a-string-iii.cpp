class Solution {
public:
    string reverseWords(string s) {
        //stack
        // TC : O (2 * n)
        int n = s.size();
        string result = "";
        stack<char> st;
        for(int i = 0; i < n; i++) {
            if(s[i] != ' ') {
                st.push(s[i]);
            } else {
                while(!st.empty()) {
                    result +=  st.top();
                    st.pop();
                }
                result += ' ';
            }
        }
        while(!st.empty()) {
                    result +=  st.top();
                    st.pop();
        }
        return result;
    }
};