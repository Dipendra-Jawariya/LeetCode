class Solution {
private:
    void func(int i,string digits,string &temp, vector<string> arr, vector<string> &ans) {
        if(i == digits.size()) {
            ans.push_back(temp);
            return;
        }
        char ch = digits[i];
        string curr = arr[ch - '0'];
        
        for(int ind = 0; ind < curr.size(); ind++) {
            temp.push_back(curr[ind]);
            func(i+1,digits,temp,arr,ans);
            temp.pop_back();
        }
    }
public:
    vector<string> letterCombinations(string digits) {
        vector<string> ans;
        int n = digits.size();
        if(n == 0) {
            return ans;
        }
        vector<string> arr = {"0", "0","abc","def","ghi","jkl", "mno","pqrs"
                             , "tuv","wxyz"};
        string temp = "";
        func(0,digits,temp,arr,ans);
        return ans;
    }
};