class Solution {
private:
    void solve(string digits,vector<string> &arr,int ind,vector<string> &ans,string &str) {
        if(ind == digits.size()) {
            ans.push_back(str);
            return;
        }
        char ch = digits[ind];
        string curr = arr[ch - '0'];
        
        for(int i = 0; i < curr.length(); i++) {
            str.push_back(curr[i]);
            solve(digits,arr,ind+1,ans,str);
            str.pop_back();
        }
        // str.push_back(curr[ind]);
        // solve(digits,arr,ind+1,ans,str);
        // str.pop_back();
        // solve(digits,arr,ind+1,ans,str);
    }
public:
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        if(digits.size() == 0) return ans;
        vector<string> arr ={"0","0","abc","def","ghi","jkl","mno","pqrs", "tuv","wxyz"};
        string temp;
        solve(digits,arr,0,ans,temp);
        return ans;
    }
};