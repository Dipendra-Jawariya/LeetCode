class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        int n = arr.size();
        int app = n / 4;
        map<int,int> mpp;
        for(auto it : arr) {
            mpp[it]++;
        }
        for(auto mp : mpp) {
            if(mp.second > app) {
                return mp.first;
            }
        }
        return -1;
    }
};