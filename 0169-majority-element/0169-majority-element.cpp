class Solution {
public:
    int majorityElement(vector<int>& nums) {
         //MOORE'S VOTING ALGORITHM
        int n = nums.size();
        int cnt = 0;
        int el;
        //apply moore's voting algoritm
        for(int i = 0; i < n; i++) {
            if(cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if(el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int cnt1 = 0;
        //verify if there is any element which is greater n/2
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == el) {
                cnt1++;
            }
        }
        
        if(cnt1 > n/2) return el;
        return -1;
    }
};