class Solution {
    int mod = 1e9 + 7;
private:
    int f(int row, int col,int sum,int &k , vector<vector<int>>& grid,vector<vector<vector<int>>> &dp) {
        if(row < 0 || col < 0 || row >= grid.size() || col >= grid[0].size()) return 0;
        if(row == 0 && col == 0) {
            sum += grid[row][col];
            if(sum % k == 0) 
            {
                cout<<sum<<endl;
                return 1;
            }
            else return 0;
        }
        if(dp[row][col][sum] != -1) return dp[row][col][sum] % mod;
        int up = f(row-1,col,(sum+grid[row][col])%k,k,grid,dp) % mod;
        int left = f(row,col-1,(sum+grid[row][col])%k,k,grid,dp) % mod;
        return dp[row][col][sum] = (up + left) % mod;
    }
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<vector<int>>> dp(n,vector(m,vector<int>(k,0)));
        dp[0][0][grid[0][0] % k] = 1;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                for(int sum = 0; sum < k; sum++) {
                    // int up = 0;
                    // if(row > 0)  dp[row-1][col][(sum + grid[row][col]) % k] % mod;
                    // int left = 0;
                    // if(col > 0)  dp[row][col-1][(sum + grid[row][col]) % k] % mod;
                    // dp[row][col][sum] = (up + left) % mod;
                    int K = (sum + grid[row][col]) % k;
                    if(row) dp[row][col][K] += dp[row-1][col][sum] % mod;
                    if(col) dp[row][col][K] += dp[row][col-1][sum] % mod;
                }
            }
        }
        return dp[n-1][m-1][0] % mod;
    }
};