class Solution {
    int mod = 1e9 + 7;
private:
    int f(int ind,string &s, int k,vector<int> &dp) {
        if(ind == s.size()) return 1;
        if(s[ind] == '0') return 0;
        
        if(dp[ind] != -1) return dp[ind];
        int ans = 0;
        long num = 0;
        for(int j = ind; j < s.size(); j++) {
              num = num * 10 + s[j] - '0';
            if(num > k) break;
            ans = (ans + f(j+1,s,k,dp)) % mod;
        }
        return dp[ind] = ans;
    }
public:
    
    int numberOfArrays(string s, int k) {
        int n = s.size();
        vector<int> dp(n,-1);
        return f(0,s,k,dp);
    }
};