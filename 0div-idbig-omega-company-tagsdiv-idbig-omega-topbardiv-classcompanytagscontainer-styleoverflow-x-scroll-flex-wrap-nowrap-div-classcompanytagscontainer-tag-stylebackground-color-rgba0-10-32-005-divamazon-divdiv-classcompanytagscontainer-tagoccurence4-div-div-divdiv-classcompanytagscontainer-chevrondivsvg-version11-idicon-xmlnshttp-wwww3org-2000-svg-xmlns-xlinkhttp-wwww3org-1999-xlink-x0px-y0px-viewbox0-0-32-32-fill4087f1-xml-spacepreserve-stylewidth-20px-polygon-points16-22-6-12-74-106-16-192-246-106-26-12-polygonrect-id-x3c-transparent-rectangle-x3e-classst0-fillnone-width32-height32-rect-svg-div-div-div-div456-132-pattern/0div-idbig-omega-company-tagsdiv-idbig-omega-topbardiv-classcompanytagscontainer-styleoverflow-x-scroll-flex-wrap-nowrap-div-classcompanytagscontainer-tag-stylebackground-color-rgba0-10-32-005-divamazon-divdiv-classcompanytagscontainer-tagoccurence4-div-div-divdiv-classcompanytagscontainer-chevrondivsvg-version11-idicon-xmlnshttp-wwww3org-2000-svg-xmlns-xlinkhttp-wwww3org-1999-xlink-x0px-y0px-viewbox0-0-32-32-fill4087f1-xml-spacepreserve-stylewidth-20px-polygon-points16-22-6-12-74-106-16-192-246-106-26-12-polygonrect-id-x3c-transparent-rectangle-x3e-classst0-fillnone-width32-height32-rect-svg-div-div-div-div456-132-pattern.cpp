class Solution {
public:
    bool find132pattern(vector<int>& nums) {
        int n = nums.size();
        if( n < 2) return false;
        
        vector<int> mini(n);
        mini[0] = nums[0];
        
        for(int i = 1; i < n; i++) {
            mini[i] = min(nums[i],mini[i-1]);
        }
        
        stack<int> st;
        for(int j = n-1; j >= 0; j--) {
            while(!st.empty() && st.top() <= mini[j]) st.pop();
            if(!st.empty() && st.top() < nums[j]) {
                return true;
            }
            st.push(nums[j]);
        }
        return false;
    }
};