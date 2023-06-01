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
        vector<vector<vector<int>>> dp(n,vector(m,vector<int>(k+1,-1)));
        // vector<vector<vector<int> > > dp(n, vector<vector<int> >(m, vector<int>(k+1,-1)));
        return f(n-1,m-1,0,k,grid,dp) % mod;
    }
};