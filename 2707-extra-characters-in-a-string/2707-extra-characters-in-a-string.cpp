class Solution {
private:
    int func(int ind,string &s,set<string> st,vector<int> &dp) {
        if(ind >= s.size()) return 0;
        if(dp[ind] != -1) return dp[ind];
        int res = INT_MAX;
        for(int i = 1; ind + i <= s.size(); i++) { // this is to have length of new substring and ind+ i is checking its index bound
            string t = s.substr(ind,i);
            if(st.find(t) != st.end()) {
                res = min(res,func(ind + i,s,st, dp));
            }
        }
        res = min(res,1+ func(ind+1,s,st,dp));
        return dp[ind] = res;
    }
public:
    int minExtraChar(string s, vector<string>& dictionary) { 
        set<string> st;
        for(auto it : dictionary) {
                st.insert(it);
        }
        int n = s.size();
        vector<int> dp(n,-1);
        return func(0,s,st,dp);
    }
};