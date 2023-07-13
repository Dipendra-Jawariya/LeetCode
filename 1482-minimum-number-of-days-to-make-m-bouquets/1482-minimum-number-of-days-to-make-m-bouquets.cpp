class Solution {
private:
    bool possible(int day,int k,int m,vector<int>& bloomDay) {
        int cnt = 0;
        int bouques = 0;
        for( int i = 0; i < bloomDay.size(); i++) {
            if(bloomDay[i] <= day) {
                cnt++;
            } else {
                bouques += (cnt / k);
                cnt = 0;
            }
        }
        bouques += (cnt / k);
        if(bouques >= m) {
            return true;
        }
        return false;
    }
private:
    int findMaxi(vector<int> &bloomDay) {
        int maxi = -1e9;
        for(int i = 0; i < bloomDay.size(); i++) {
            if(maxi < bloomDay[i]) {
                maxi = bloomDay[i];
            }
        }
        return maxi;
    }
private:
    int findMini(vector<int>& bloomDay) {
        int mini = 1e9;
        for(int i = 0; i < bloomDay.size(); i++) {
            if(mini > bloomDay[i]) {
                mini = bloomDay[i];
            }
        }
        return mini;
    }
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        int n = bloomDay.size();
        if((long long)m * k > n) {
            return -1;
        }
        int low = findMini(bloomDay);
        int high = findMaxi(bloomDay);
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(possible(mid,k,m,bloomDay)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
};