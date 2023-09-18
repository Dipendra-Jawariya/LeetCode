class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        int n = mat.size();
        int m = mat[0].size();
        
        vector<pair<int,int>> arr;
        for(int i = 0; i < n; i++) {
            int sum = accumulate(mat[i].begin(),mat[i].end(),0);
            arr.push_back({sum,i});
        }
        sort(arr.begin(),arr.end());
        vector<int> res;
        
        for(int i = 0; i < k; i++) {
            res.push_back(arr[i].second);
        }
        return res;
    }
};