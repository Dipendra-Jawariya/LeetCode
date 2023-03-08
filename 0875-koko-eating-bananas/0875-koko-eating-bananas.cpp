class Solution {
public:
    long long getHoursToEatAll(vector<int>& piles, int bananasPerHour) {
        long long totalHours = 0;
        for(int pile : piles) {
            int div =  pile / bananasPerHour;
            totalHours += div;
            if(pile % bananasPerHour != 0) totalHours++;
        }
        return totalHours;
    }
    int minEatingSpeed(vector<int>& piles, int targetHours) {
        int low = 1;
        int high = *(max_element(piles.begin(),piles.end()));
        int ans = -1;
        
        while(low <= high) {
            int mid = low + (high - low) /2;
            long long hourseToEatAll = getHoursToEatAll(piles,mid);
            
            if(hourseToEatAll <= targetHours) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
};