class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        int n = nums.size();
        int mini = INT_MAX;
        int maxi = INT_MIN;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] % 2 != 0) {
                nums[i] = 2 * nums[i];
            }
            mini = min(nums[i],mini);
            maxi = max(nums[i],maxi);
        }
        
        priority_queue<int> pq;
        for(int it: nums){
            pq.push(it);
        }
        int min_deviation = maxi - mini;
        int top = 0;
        while(pq.top() % 2 == 0) {
            top = pq.top();
            pq.pop();
            min_deviation = min(min_deviation,top - mini);
            mini  = min(top/2,mini);
            pq.push(top/2);
        }
        top = pq.top();
        min_deviation = min(min_deviation,top - mini);
        return min_deviation;
    }
};