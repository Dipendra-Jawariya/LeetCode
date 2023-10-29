class Solution {
long long mod = 1e9 + 7;
private:
    void myPow(long long x,long long n, long long &ans) {
        if(n <= 0) return;
        
        if(n % 2 == 1) {
            ans = (ans * x) % mod;
            n = n -1;
        } else {
            x = (x * x) % mod;
            n = n / 2;
        }
        myPow(x,n,ans);
    }
public:
    int countGoodNumbers(long long n) {
        // Recursive Solution
        long long oddIndx = n / 2;
        long long evenIndx = n - oddIndx;
        
        long long ans = 1;
        myPow(5,evenIndx,ans);
        myPow(4,oddIndx,ans);
        return ans;
    }
};