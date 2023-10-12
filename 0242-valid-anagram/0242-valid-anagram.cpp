class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.size() != t.size()) return false;
        map<char,int> mpp;
        for(char ch : t) {
            mpp[ch]++;
        }
        for(int i = 0; i < s.size(); i++) {
            if(mpp.find(s[i]) == mpp.end()) return false;
            mpp[s[i]]--;
            if(mpp[s[i]] == 0) mpp.erase(s[i]);
        }
        return true;
    }
};