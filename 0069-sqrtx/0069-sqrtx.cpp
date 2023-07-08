class Solution {
public:
    int mySqrt(int x) {
        long long int low = 0,high = x;
        long long int ans = 0;
        while(low <= high) {
            long long int mid = (low + high) / 2;
            if( mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)ans;
    }
};