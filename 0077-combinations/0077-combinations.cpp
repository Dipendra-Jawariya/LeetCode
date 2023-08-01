class Solution {
public:
    vector<vector<int>>res;
    void solve(int ind,int n,int size,vector<int> &ans) {
        if(ans.size() == size) {
            res.push_back(ans);
            return;
        }
        for(int i = ind;i <= n; i++) {
            ans.push_back(i);
            solve(i+1,n,size,ans);
            ans.pop_back();
        }
    }
public:
    
    vector<vector<int>> combine(int n, int k) {
        vector<int> ans;
        solve(1,n,k,ans);
        return res;
    }
};