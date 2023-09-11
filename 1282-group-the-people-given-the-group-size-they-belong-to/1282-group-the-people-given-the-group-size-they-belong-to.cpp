class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        int n = groupSizes.size();
        vector<vector<int>> ans;
        
        for(int i = 1; i <= groupSizes.size(); i++) {
            
            vector<int> subArr;
            for(int j = 0; j < n; j++) {
                if(groupSizes[j] == i) {
                    if(subArr.size() == i) {
                        ans.push_back(subArr);
                        subArr.clear();
                    }
                    subArr.push_back(j);
                }
            }
            if(subArr.size()) {
                ans.push_back(subArr);
            }
        }
        return ans;
    }
};