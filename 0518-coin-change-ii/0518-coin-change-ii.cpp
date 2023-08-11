class Solution {
private:
    int f(int ind,int sum,int n,int amount,vector<int> &coins,vector<vector<int>> &dp) {
        if(sum == amount) {
            return 1;
        }
        
        if(ind == n) {
            // if(sum == amount) {
            //     return 1;
            // }
            return 0;
        }
        
        if(dp[ind][sum] != -1) return dp[ind][sum];
        
        int pick = 0;
        if(coins[ind] + sum <= amount) {
            pick = f(ind,sum+coins[ind],n,amount,coins,dp);
        }
        int notPick = f(ind+1,sum,n,amount,coins,dp);
        return dp[ind][sum] = pick+notPick;
    }
public:
    int change(int amount, vector<int>& coins) {
        int n = coins.size();
        vector<vector<int>> dp(n+1,vector<int>(amount,-1));
        return f(0,0,n,amount,coins,dp);
    }
};