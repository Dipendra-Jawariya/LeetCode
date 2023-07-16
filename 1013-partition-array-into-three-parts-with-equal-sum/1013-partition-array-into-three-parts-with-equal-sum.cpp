class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        int n = arr.size();
        int total_sum = 0;
        for(auto it : arr) total_sum += it;
        if(total_sum % 3 != 0) {
             return false;
        }
        
        int part = total_sum / 3;
        int curr_sum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            curr_sum += arr[i];
            if(curr_sum == part){ 
                cnt++;
                curr_sum = 0;
            }
            
        }
        // if(curr_sum == part) cnt++;
        if(cnt >= 3) return true;
        return false;
    }
};