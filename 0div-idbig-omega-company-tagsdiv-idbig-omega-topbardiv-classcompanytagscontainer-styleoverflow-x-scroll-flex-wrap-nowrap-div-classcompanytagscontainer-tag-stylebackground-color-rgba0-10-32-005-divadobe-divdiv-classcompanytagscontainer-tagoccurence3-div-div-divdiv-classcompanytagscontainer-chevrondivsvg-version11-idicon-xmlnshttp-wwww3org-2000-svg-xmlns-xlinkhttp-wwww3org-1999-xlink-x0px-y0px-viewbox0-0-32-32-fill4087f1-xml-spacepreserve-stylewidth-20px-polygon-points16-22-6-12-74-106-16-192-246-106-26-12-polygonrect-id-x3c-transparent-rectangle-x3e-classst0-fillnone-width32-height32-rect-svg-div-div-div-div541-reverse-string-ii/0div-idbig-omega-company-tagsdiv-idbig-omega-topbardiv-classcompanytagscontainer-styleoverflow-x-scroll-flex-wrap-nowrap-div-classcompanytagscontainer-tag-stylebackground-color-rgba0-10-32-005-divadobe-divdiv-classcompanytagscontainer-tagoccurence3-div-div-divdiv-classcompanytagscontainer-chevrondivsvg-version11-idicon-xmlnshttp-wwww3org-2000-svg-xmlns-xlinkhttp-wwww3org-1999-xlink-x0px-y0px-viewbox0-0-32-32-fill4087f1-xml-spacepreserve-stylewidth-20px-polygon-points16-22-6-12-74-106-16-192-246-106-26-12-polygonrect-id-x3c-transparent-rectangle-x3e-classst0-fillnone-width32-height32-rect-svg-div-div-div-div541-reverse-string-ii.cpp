class Solution {
public:
    string reverseStr(string s, int k) {
        int n = s.size();
        for(int i = 0; i < n; i += 2*k) {
            int start = i, end = min((start + k - 1),(n - 1));
            while(start < end) {
                char temp = s[start];
                s[start++] = s[end];
                s[end--] = temp;
            }
        }
        return s;
    }
};