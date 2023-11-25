class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        int n = nums.size();
        
        vector<int> preSum;
        preSum.push_back(nums[0]);
        for(int i = 1; i < n; i++) {
            preSum.push_back(nums[i] + preSum[i - 1]);
        }
        
        vector<int> ans;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            
            int prevElements = i + 1;
            int nextElements = n - 1 - i;
            // Left Half
            int leftTotal  = ((prevElements * nums[i]) - preSum[i]);
            
            // Right Half
            int contribution = preSum[n - 1] - preSum[i];
            int rightTotal  = (contribution  - (nums[i] * nextElements));
            
            ans.push_back(leftTotal + rightTotal);
        }
        return ans;
    }
};