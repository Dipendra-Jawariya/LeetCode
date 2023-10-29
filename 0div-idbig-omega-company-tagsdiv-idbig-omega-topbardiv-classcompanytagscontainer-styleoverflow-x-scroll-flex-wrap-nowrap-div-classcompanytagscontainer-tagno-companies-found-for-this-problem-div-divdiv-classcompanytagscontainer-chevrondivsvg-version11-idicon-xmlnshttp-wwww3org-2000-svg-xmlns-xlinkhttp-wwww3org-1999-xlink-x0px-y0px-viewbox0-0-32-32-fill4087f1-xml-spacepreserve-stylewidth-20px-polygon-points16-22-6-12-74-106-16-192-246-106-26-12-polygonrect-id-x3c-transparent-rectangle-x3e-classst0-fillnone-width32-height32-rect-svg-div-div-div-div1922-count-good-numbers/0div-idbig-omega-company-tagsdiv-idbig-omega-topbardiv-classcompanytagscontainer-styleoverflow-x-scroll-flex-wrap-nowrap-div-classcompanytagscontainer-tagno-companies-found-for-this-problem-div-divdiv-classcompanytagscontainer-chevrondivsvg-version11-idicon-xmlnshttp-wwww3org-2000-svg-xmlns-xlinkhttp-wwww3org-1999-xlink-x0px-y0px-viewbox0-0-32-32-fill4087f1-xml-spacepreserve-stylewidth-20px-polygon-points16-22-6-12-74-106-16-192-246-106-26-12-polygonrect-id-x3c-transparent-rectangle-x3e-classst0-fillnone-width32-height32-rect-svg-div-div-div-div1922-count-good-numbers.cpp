class Solution {
private:
    void func(long long n,long long int x,long long &ans,long long mod) {
        // if(nn <= 0) return;
        ans = ans % mod;
        long long nn = n;
        if(nn < 0) {
            nn = -1 * nn;
        }
        
        while(nn > 0) {
            // ans = ans % mod;
            if(nn % 2 == 1) {
                ans = (ans * x) % mod;
                nn = nn -1;
            } else {
                x = (x * x) % mod;
                nn = nn / 2;
            }
        }
        // if(n < 0) {
        //     ans = 1 / ans;
        // }
    }
public:
    int countGoodNumbers(long long n) {
        long long odd = n / 2;
        long long even = n - odd;
        long long mod = 1e9 + 7;
        long long ans = 1;
        long long int evenPos = 5;
        long long int oddPos = 4;
        func(even,evenPos,ans,mod);
        func(odd,oddPos,ans,mod);
        return (int)ans % mod;
    }
};