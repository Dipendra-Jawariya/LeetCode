class Solution {
public:
    string reverseWords(string s) {
        int n = s.size();
        int lastIndex = -1;
        for(int startIndx = 0; startIndx <= n; startIndx++) {
            if(startIndx == n || s[startIndx] == ' ') {
                int start = lastIndex + 1;
                int end = startIndx - 1;
                while(start < end) {
                    char temp = s[start];
                    s[start++] = s[end];
                    s[end--] = temp;
                }
                lastIndex = startIndx;
            }
        }
        return s;
    }
};