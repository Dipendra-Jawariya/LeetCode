class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        int n = nums1.size();
        unordered_map<long long,int> mpp;
        for(int i = 0; i < n; i++) {
            for(int k = 0; k < n; k++) {
                mpp[nums4[i] + nums3[k]]++;
            }
        }
        // set<vector<int>> st;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                long long sum = nums1[i];
                sum += nums2[j];
                long long rem =  -(sum);
                if(mpp.find(rem) != mpp.end()) {
                    count += mpp[rem];
                }  
            }
        }
        return count;
    }
};