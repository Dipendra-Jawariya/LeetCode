class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        // int max_prod = INT_MIN;
        // for(int i = 0; i < n; i++) {
        //     int prod = 1;
        //     for(int j = i; j < n; j++) {
        //         prod *= nums[j]; 
        //         max_prod = max(max_prod,prod);
        //     }
        // }
        // return max_prod;
        int pre = 1, suff = 1;
        int maxi = INT_MIN;
        for(int i = 0 ; i < n; i++) {
            if(pre == 0) pre = 1;
            if(suff == 0) suff = 1;
            pre *= nums[i];
            suff *= nums[n-i-1];
            maxi = max(maxi,max(pre,suff));
        }
        return maxi;
    }
};