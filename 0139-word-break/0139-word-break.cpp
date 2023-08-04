class Solution {
private:
    bool f(int ind,string s,unordered_set<string> st,vector<int> &dp) { 
        if(ind == s.size()) return true;
        
        if(dp[ind] != -1) return dp[ind];
        
        string temp = "";
        for(int i = ind; i < s.size(); i++) {
            temp += s[i];
            if(st.find(temp) != st.end()) {
                if(f(i + 1, s,st,dp)) return dp[i] = 1;
            }
        }
        return dp[ind] = 0;
    }
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> st;
        for(string it : wordDict) {
            st.insert(it);
        }
        vector<int> dp(s.size(),-1);
        
        return f(0,s,st,dp);
    }
};