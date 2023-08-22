class Solution {
public:
    string convertToTitle(int columnNumber) {
        string ans;
        while(columnNumber) {
            columnNumber--;
            ans = ans + (char)(columnNumber % 26 + 'A');
            columnNumber = (columnNumber) / 26;
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};