class Solution {
private:
    void f(long nn,double x,double &ans) {
        if(nn <= 0) {
            return;
        }
        
        if(nn % 2 == 1) {
            ans = ans * x;
            nn = nn - 1;
        } else {
            x = x * x;
            nn = nn / 2;
        }
        f(nn,x,ans);
    }
public:
    double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        // making it positive
        if(nn < 0) {
            nn = -1 * nn;
        }
        f(nn,x,ans);
        if(n < 0) {
            ans = (double) 1.0 / ans;
        }
        return ans;
    }
};