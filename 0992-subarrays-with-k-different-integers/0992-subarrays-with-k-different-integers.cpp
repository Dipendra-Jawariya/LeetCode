class Solution {
private:
    int countsubArrwithKDist(vector<int> &nums,int k)  {
        int n = nums.size();
        unordered_map<int,int> mpp;
        int i = 0;
        int cnt = 0;
        for(int j = 0; j < n; j++) {
            mpp[nums[j]]++;
            
            while(mpp.size() > k) {
                mpp[nums[i]]--;
                if(mpp[nums[i]] == 0) mpp.erase(nums[i]);
                i++;
            }
            // for(auto it : mpp) {
            //     cout<<it.first<< " ";
            // }
            // cout<<endl;
            cnt += j - i + 1;
        }
        return cnt;
    }
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        return countsubArrwithKDist(nums,k) - countsubArrwithKDist(nums,k-1);
    }
};