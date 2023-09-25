class Solution {
public:
    char findTheDifference(string s, string t) {
        map<char,int> mpp;
        for(int i = 0; i < t.size(); i++) {
            mpp[t[i]]++;
            if(i != t.size() - 1) {
                mpp[s[i]]++;
            }
        }
        for(auto it : mpp) {
            cout<<it.first<<" " << it.second<<endl;
            if(it.second % 2 == 1) {
                return it.first;
            }
        }
        return 'a';
    }
};