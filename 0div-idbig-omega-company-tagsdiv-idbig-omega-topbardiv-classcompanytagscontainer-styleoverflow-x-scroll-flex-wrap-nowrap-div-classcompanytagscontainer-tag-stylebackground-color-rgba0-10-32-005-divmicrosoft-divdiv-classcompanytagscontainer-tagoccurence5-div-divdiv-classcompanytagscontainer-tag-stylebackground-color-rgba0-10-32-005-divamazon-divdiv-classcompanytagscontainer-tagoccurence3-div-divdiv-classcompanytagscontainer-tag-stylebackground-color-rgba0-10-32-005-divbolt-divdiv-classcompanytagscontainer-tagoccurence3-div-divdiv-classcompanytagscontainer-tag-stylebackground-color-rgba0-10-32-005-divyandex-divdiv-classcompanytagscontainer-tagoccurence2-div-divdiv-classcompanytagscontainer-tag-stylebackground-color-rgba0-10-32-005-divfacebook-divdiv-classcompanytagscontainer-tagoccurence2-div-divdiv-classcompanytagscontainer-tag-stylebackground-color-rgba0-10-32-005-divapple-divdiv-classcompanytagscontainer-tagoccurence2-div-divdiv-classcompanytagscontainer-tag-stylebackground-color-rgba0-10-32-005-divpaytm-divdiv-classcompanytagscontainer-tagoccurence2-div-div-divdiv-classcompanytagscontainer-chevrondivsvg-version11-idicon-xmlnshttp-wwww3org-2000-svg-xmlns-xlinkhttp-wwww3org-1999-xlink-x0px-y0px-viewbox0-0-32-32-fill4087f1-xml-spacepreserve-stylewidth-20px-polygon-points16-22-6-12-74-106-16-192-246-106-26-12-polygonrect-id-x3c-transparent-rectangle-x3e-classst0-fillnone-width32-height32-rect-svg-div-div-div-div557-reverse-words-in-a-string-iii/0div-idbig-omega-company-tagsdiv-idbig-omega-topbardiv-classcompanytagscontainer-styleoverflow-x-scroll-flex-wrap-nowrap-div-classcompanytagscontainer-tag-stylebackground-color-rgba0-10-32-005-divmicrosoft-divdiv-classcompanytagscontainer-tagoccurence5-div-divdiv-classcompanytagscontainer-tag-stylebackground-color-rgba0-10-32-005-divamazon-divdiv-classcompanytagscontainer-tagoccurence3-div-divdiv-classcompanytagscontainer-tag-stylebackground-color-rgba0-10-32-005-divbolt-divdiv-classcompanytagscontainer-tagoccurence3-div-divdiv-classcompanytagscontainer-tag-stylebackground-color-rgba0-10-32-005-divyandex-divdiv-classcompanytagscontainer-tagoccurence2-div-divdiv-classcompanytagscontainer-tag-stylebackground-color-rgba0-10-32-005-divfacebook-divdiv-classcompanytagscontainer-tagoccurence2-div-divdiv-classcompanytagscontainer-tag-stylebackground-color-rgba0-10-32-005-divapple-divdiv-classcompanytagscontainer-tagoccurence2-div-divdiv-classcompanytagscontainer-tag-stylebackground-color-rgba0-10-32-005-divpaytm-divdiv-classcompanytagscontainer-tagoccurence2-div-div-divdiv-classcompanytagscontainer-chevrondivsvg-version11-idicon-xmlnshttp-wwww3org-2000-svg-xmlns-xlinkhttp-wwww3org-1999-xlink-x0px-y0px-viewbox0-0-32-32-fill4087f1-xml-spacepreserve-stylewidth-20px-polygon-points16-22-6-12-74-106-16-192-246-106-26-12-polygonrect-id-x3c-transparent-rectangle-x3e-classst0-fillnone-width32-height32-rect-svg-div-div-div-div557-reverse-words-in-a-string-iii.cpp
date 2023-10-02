class Solution {
public:
    string reverseWords(string s) {
        int n = s.size();
        int lastSpace = -1;
        for(int i = 0; i <= n; i++) {
            if(i == n || s[i] == ' ') {
                int startIndx = lastSpace + 1;
                int endIndx = i - 1;
                while(startIndx < endIndx) {
                    char temp = s[startIndx];
                    s[startIndx++] = s[endIndx];
                    s[endIndx--] = temp;
                }
                lastSpace = i;
            }
        }
        return s;
    }
};