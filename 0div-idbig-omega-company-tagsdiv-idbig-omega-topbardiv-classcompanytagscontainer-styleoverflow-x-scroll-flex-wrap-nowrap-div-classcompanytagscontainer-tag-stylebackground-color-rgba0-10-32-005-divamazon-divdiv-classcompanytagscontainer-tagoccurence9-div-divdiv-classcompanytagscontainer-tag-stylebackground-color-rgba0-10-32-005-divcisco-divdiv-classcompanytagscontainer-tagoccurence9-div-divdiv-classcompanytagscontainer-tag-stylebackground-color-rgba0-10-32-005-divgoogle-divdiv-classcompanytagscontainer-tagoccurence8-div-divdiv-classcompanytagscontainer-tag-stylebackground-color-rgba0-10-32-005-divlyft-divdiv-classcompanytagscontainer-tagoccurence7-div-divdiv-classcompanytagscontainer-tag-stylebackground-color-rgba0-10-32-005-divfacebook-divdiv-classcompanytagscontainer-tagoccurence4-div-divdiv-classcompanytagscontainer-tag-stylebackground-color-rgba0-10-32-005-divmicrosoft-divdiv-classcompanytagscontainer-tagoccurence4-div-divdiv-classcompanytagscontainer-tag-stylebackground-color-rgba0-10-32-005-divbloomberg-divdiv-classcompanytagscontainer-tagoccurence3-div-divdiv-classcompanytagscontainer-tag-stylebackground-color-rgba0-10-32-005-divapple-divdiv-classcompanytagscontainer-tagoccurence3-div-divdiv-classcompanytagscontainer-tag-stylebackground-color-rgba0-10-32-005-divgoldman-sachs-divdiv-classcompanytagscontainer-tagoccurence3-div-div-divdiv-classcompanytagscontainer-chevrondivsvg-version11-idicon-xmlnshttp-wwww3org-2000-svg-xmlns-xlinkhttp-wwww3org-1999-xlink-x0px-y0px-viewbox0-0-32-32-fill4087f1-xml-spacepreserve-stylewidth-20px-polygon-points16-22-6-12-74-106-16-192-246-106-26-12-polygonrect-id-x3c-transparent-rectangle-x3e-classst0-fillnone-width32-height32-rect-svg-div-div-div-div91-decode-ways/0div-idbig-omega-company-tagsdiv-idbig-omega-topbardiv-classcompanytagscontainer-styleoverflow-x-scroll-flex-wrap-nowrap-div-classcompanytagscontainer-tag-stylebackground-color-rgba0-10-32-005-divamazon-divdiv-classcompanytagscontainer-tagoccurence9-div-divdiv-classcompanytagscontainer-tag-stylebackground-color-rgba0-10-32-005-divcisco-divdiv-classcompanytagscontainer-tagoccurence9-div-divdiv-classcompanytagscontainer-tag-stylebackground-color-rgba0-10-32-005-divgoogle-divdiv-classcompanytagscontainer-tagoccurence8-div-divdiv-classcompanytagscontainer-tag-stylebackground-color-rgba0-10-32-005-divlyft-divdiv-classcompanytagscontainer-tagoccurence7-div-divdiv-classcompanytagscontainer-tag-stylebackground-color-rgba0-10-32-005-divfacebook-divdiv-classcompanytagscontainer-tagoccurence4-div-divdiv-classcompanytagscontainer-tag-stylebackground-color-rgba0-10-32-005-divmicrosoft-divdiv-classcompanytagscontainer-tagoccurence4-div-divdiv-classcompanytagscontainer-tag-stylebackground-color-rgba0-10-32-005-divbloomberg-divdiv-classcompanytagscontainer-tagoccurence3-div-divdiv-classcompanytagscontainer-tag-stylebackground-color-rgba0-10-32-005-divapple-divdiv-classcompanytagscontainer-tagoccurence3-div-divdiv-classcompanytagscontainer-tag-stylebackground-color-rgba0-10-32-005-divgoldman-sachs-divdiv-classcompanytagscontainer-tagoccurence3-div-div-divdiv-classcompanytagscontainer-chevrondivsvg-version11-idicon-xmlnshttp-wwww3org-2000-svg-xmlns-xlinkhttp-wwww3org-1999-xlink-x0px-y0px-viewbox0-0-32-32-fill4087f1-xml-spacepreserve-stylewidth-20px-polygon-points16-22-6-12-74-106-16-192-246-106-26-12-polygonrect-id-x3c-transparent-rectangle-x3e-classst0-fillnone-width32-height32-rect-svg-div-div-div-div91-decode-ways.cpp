class Solution {
private:
    int f(int ind,string s,vector<int> &dp) {
        if(s[ind] == '0') return 0;
        if(ind >= s.size()- 1) {
            return 1;
        }
        if(dp[ind] != -1) {
            return dp[ind];
        }
        int ans = f(ind+1,s,dp);
        if(stoi(s.substr(ind,2)) <= 26) {
            ans += f(ind+2,s,dp);
        }
        return dp[ind] = ans;
    }
public:
    int numDecodings(string s) {
        vector<int> dp(s.size()+1, -1);
        return f(0,s,dp);
    }
};