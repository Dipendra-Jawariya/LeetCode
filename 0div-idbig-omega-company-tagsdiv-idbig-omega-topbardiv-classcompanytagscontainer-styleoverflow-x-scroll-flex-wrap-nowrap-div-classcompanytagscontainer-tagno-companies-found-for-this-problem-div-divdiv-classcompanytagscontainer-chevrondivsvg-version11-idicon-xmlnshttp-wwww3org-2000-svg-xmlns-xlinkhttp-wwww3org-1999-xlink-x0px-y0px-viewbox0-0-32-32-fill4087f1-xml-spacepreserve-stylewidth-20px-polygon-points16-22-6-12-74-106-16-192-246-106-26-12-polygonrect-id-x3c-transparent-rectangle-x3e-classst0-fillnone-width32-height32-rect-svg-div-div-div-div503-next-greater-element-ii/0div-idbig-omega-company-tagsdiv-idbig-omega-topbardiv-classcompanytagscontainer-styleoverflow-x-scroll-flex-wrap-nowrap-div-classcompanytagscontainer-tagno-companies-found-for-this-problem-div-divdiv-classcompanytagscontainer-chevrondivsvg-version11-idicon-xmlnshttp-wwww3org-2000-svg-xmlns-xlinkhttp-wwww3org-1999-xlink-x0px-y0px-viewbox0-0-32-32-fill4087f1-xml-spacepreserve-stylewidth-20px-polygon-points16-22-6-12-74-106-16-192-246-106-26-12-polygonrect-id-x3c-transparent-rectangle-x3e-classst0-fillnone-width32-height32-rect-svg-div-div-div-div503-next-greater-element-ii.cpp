class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n);
        stack<int> st;
        for(int i = 2 * n -1; i >= 0; i--) {
            while(!st.empty() && st.top() <= nums[i % n]) {
                st.pop();
            } 
            if(i < n) {
                if(!st.empty()) {
                    res[i] = st.top();
                } else {
                    res[i] = -1;
                }
                
            }
            st.push(nums[i % n]);
        }
        return res;
    }
};