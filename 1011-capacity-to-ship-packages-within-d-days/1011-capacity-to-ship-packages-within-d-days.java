class Solution {
    private boolean isPossible(int weights[],int maxW,int days) {
        int d = 1, currW = 0;
        for(int i = 0; i < weights.length; i++) {
            if(currW + weights[i] <= maxW) {
                currW += weights[i];
            } else {
                d++;
                currW = weights[i];
            }
        }
        if(d <= days) {
             return true;
        } else {
             return false;
        }
    }
    public int shipWithinDays(int[] weights, int days) {
        int high = 0;
        int low = Integer.MIN_VALUE;
        int n = weights.length;
        for(int i = 0; i < n; i++) {
            high += weights[i];
            if(weights[i] > low ) {
                low = weights[i];
            }
        }
        int ans = high;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(isPossible(weights,mid,days)) {
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return ans;
    }
}