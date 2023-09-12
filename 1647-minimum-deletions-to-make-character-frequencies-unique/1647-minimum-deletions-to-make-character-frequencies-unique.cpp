class Solution {
public:
    int minDeletions(string s) {
        unordered_map<char,int> mpp;
        for(char ch : s) {
            mpp[ch]++;
        }
        int ans = 0;
        set<int> st;
        for(auto [ch,count] : mpp) {
            while(st.find(count) != st.end()) {
                count--;
                ans++;
            }
            if(count > 0) {
                st.insert(count);
            }
        }
        return ans;
    }
};