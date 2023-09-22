class Solution {
public:
    bool isSubsequence(string s, string t) {
        int n = s.size();
        int m = t.size();
        
        int i = 0, j = 0;
        while(i < n) {
            if(s[i] == t[j]) {
                i++; j++;
                continue;
            }
            else {
                j++;
            }
            if( j >= m) return false;
        }
        return true;
    }
};