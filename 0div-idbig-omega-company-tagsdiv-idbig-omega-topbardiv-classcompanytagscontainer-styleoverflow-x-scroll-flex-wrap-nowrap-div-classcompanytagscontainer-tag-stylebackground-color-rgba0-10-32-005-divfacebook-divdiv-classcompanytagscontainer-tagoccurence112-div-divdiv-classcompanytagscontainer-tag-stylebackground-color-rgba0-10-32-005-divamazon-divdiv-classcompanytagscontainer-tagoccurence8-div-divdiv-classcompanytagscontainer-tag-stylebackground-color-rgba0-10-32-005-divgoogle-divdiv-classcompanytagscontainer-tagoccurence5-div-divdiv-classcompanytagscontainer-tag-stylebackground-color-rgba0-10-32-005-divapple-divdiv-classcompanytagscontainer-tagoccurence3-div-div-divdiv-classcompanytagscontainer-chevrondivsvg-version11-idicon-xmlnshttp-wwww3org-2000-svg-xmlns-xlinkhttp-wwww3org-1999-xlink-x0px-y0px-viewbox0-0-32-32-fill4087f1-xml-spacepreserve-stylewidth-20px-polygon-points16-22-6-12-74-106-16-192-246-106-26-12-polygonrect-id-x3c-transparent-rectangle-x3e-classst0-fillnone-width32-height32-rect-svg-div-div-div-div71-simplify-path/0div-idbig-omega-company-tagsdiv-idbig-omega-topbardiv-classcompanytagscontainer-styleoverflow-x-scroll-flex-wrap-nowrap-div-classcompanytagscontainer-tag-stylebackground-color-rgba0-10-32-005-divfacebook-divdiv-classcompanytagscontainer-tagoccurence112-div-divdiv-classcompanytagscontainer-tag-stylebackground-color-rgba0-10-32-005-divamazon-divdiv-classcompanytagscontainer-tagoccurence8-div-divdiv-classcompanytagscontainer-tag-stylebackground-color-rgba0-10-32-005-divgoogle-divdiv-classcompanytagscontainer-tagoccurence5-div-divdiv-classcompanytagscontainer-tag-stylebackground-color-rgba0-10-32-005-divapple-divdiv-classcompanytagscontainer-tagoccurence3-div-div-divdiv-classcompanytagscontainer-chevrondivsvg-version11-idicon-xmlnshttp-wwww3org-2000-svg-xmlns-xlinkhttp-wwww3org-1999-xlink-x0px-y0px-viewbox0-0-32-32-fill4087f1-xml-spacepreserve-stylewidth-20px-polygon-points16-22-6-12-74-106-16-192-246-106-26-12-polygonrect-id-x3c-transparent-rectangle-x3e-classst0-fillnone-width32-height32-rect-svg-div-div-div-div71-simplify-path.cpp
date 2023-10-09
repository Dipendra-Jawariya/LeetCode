class Solution {
public:
    string simplifyPath(string path) {
        int n = path.size();
        stack<string> st;
        
        for(int i = 0; i < n; i++) {
            if(path[i] == '/') {
                continue;
            }
            //form the string and find if it is '..'  OR it Is and directory
            string temp = "";
            while(i < n && path[i] != '/') {
                temp += path[i];
                i++;
            }
            if(temp == ".") {
                continue;
            }
            else if(temp == "..") {
                if(!st.empty()) {
                    st.pop();
                }
            }
            else {
                st.push(temp);
            }
        }
        string res = "";
        while(!st.empty()) {
            res = "/" + st.top() + res;
            st.pop();
        }
        if(res.size() == 0) {
            return "/";
        }
        return res;
    }
};