class Solution {
private:
    void f(int ind,vector<int> &nums,vector<int> ds,vector<vector<int>> &ans,vector<int> &freq) {
        if(ds.size() == nums.size()) {
            ans.push_back(ds);
            return;
        }
        for(int i = 0; i < nums.size(); i++) {
            if(!freq[i]) {
                ds.push_back(nums[i]);
                freq[i] = 1;
                f(i+1,nums,ds,ans,freq);
                ds.pop_back();
                freq[i] = 0;
            }
        }
    }
private:
    void permutation(int ind,vector<int> &nums,vector<vector<int>> &ans) {
        if(ind == nums.size()) {
            ans.push_back(nums);
            return;
        }
        
        for(int i = ind; i < nums.size(); i++) {
            swap(nums[i],nums[ind]);
            permutation(ind + 1,nums,ans);
            swap(nums[i],nums[ind]);
        }
    }
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        // vector<int> ds;
        // vector<int> freq(nums.size(),0);
        // f(0,nums,ds,ans,freq);
        permutation(0,nums,ans);
        return ans;
    }
};