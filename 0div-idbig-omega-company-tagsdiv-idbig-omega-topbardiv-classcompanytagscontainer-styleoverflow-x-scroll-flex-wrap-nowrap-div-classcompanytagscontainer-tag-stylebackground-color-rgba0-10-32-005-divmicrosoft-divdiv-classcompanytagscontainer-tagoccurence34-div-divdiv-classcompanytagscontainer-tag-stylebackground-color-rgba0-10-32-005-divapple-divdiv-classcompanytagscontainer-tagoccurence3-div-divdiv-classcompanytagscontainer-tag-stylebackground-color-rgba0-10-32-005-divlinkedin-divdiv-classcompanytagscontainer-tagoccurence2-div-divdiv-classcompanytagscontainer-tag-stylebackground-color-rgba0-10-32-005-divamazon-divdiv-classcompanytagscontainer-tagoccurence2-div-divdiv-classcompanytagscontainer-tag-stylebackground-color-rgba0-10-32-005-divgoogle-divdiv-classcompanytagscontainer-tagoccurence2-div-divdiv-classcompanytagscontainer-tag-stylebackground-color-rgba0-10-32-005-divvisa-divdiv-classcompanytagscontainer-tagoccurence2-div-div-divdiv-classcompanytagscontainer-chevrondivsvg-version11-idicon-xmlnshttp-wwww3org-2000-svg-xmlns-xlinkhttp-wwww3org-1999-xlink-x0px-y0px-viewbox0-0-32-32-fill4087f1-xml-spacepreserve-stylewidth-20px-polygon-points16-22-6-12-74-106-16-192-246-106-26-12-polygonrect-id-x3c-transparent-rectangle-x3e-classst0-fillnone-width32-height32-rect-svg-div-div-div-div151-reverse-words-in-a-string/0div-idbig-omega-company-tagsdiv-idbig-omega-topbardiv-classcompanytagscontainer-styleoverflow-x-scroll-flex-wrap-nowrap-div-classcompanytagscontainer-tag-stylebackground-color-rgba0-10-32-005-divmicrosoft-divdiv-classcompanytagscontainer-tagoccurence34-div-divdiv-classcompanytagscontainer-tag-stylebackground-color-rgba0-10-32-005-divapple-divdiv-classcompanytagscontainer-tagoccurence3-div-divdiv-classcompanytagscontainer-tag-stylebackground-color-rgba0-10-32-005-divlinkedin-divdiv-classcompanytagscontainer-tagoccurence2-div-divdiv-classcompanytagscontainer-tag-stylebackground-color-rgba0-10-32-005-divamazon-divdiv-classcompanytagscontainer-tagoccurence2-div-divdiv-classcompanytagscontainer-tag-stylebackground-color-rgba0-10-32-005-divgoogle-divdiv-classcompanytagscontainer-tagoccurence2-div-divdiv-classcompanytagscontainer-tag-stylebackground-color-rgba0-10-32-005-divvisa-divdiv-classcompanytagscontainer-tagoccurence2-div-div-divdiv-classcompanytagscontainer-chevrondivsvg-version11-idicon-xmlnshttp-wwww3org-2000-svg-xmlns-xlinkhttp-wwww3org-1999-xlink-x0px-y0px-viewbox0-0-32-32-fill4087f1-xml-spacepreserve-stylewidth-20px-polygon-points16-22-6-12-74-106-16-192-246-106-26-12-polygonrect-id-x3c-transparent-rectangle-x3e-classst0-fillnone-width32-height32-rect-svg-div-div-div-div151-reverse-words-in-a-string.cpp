class Solution {
public:
    string reverseWords(string s) {
        int n = s.size();
        int i = n - 1;
        string ans = "";
        while( i >= 0) {
            
            // trailing zeros check
             while( i >= 0 && s[i] == ' ') {
                 i--;
             }
            
            int j = i;
            
            if(i < 0) break;
            
            while(i >= 0 && s[i] != ' ') {
                i--;
            }
            if(ans == "") {
                ans += s.substr(i+1, j - i);
            } else {
                ans += " ";
                ans += s.substr(i+1, j - i);
            }
        }
        return ans;
    }
};