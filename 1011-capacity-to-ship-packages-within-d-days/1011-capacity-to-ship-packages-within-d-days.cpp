class Solution {
public:
    bool isPossible(vector<int>& weights,int maxW,int days) {
        int d = 1, currW = 0;
        for(auto w : weights) {
            if(w + currW <= maxW) {
                currW += w;
            }else {
                d++;
                currW = w;
            }
        }
        if(d <= days) {
            return true;
        }
        return false;
    }
    int shipWithinDays(vector<int>& weights, int days) {
        int low = INT_MIN,high = 0;
        for(auto w : weights) {
            high += w;
            low = max(low,w);
        }
        int ans;
        while(low <= high ) {
            int mid = low +( high - low )/ 2;
            if(isPossible(weights,mid,days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
};