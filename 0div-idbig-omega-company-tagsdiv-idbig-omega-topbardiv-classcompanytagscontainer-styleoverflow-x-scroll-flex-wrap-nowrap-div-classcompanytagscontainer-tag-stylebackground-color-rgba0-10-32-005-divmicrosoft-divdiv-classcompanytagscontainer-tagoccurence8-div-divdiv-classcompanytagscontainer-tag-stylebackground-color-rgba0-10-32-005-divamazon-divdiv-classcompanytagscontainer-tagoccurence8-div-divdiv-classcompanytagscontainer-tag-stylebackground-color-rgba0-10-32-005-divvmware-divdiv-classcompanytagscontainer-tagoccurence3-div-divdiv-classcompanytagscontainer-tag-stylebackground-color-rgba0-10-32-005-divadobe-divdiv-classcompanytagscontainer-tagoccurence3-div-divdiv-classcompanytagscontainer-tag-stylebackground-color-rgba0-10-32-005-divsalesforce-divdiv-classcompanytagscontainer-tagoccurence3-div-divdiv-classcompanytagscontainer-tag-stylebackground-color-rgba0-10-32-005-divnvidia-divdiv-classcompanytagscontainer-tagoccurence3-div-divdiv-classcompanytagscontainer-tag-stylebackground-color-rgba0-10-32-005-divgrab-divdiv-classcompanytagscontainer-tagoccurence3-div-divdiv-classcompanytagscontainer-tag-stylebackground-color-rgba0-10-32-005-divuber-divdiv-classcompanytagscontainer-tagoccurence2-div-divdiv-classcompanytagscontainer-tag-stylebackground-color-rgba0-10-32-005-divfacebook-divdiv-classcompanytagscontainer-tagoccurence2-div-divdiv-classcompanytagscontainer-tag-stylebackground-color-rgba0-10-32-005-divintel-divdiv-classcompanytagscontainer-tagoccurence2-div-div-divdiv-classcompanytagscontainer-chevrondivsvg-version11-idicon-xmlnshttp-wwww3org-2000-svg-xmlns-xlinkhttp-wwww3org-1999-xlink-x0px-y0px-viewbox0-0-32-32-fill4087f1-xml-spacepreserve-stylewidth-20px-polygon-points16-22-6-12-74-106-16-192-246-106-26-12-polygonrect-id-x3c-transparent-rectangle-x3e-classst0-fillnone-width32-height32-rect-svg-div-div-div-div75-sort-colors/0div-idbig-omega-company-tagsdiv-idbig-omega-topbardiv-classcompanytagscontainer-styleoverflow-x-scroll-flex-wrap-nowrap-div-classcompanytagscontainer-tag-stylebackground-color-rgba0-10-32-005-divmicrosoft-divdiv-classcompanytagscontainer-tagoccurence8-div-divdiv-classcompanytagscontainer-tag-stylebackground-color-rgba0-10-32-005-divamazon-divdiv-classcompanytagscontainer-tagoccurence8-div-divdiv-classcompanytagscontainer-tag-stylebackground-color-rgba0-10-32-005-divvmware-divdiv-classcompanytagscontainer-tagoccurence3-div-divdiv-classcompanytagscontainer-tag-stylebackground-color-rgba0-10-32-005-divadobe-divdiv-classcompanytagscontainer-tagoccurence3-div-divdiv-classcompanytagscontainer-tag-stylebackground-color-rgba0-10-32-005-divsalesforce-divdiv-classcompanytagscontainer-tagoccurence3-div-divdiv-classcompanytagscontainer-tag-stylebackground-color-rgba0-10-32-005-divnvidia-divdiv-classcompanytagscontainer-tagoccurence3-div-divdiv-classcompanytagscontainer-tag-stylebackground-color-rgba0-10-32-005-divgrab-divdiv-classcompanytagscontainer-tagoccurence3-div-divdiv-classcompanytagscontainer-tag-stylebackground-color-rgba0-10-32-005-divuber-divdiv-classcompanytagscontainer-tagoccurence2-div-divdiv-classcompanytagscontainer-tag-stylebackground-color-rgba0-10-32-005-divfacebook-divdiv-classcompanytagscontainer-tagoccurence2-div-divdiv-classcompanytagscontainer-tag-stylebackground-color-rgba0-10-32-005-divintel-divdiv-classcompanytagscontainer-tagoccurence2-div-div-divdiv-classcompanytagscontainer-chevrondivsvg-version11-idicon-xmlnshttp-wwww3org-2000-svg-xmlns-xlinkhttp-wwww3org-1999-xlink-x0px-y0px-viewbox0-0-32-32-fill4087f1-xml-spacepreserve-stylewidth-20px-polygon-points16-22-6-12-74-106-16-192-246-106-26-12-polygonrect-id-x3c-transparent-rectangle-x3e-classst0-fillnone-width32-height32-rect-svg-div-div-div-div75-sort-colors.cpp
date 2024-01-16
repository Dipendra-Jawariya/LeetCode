class Solution {
private:
    void rec(int ind,vector<int> &nums , int &one,int &zero, int &two) {
        if(ind >= nums.size()) return;
        
        if(nums[ind] == 0) {
            zero++;
        } else if(nums[ind] == 1) {
            one++;
        } else {
            two++;
        }
        rec(ind+1,nums,one,zero, two);
    }
public:
    void sortColors(vector<int>& nums) {
        int one = 0;
        int zero = 0;
        int two = 0;
        rec(0,nums, one ,zero, two);
        // cout<< zero<<" " << one << " "<< two << endl;
        for (int i = 0; i < zero; i++) nums[i] = 0; // replacing 0's

        for (int i = zero; i < zero + one; i++) nums[i] = 1; // replacing 1's

        for (int i = one + zero; i < nums.size(); i++) nums[i] = 2;
    }
};