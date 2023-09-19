class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int n = nums.size();
        vector<int> arr(n,0);
        for(int it : nums) {
            arr[it]++;
        }
        for(int i = 1; i < n; i++) {
            if(arr[i] > 1) {
                return i;
            } 
        }
        return -1;
    }
};