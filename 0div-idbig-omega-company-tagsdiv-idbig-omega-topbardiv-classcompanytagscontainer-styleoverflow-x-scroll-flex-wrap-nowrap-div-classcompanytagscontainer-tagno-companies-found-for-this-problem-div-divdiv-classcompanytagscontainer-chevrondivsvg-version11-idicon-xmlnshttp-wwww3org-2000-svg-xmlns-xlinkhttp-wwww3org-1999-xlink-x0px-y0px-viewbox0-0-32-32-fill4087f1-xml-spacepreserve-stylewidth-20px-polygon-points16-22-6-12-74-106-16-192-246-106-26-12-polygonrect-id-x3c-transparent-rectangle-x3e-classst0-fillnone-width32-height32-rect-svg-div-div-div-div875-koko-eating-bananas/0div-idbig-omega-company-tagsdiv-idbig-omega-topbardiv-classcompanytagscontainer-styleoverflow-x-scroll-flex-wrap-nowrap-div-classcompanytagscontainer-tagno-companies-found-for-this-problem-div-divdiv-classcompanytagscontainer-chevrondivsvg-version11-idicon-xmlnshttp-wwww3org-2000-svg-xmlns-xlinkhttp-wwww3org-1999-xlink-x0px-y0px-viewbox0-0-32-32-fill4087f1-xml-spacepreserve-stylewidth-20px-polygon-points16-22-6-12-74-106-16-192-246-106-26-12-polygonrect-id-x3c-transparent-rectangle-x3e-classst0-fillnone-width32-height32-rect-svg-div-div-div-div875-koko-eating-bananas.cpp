class Solution {
private:
    int findMax(vector<int> & piles) {
        int maxi = INT_MIN;
        for(int i = 0; i < piles.size(); i++) {
            if(piles[i] > maxi) maxi = piles[i];
        }
        return maxi;
    }
private:
    int func(int hourlySpeed,vector<int> & piles, int h) {
        int totalTime = 0;
        for(int i = 0; i < piles.size(); i++) {
            totalTime += ceil((double) (piles[i]) / (double)(hourlySpeed));
            if(totalTime > h) break;
        }
        return totalTime;
    }
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();
        
        // int maxi = *max_element(piles.begin(),piles.end());
        int low = 1 , high = findMax(piles);
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int reqTime = func(mid,piles,h);
            if(reqTime <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};