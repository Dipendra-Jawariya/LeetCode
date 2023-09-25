class Solution {
public:
    char findTheDifference(string s, string t) {
        sort(s.begin(),s.end());
        sort(t.begin(),t.end());
        int i = 0;
        int n = t.size();
        for(i = 0; i < n; i++) {
            if(i == s.size()) break;
            if(s[i] != t[i])  return t[i];
        }
        return t[i];
    }
};