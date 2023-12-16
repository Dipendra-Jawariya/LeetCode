class Solution {
public:
    string destCity(vector<vector<string>>& paths) {
        unordered_set<string> hasOutGoing;
        for(int i = 0; i < paths.size(); i++) {
            hasOutGoing.insert(paths[i][0]);
        }
        
        for(int i = 0; i < paths.size(); i++) {
            string candidate = paths[i][1];
            if(hasOutGoing.find(candidate) == hasOutGoing.end()) {
                return candidate;
            }
        }
        return "";
    }
};