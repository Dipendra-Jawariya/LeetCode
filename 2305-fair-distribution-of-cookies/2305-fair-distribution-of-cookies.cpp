class Solution { 
private:
    void f(int ind,vector<int> &cookies,vector<int> &temp,int k,int &ans) {
        int n = cookies.size();
        if(ind == n) {
            int maxi = INT_MIN;
            for(int i = 0; i < k; i++) {
                maxi = max(maxi,temp[i]);
            }
            ans = min(ans,maxi);
            return;
        }
        
        for(int i = 0; i < k; i++) {
            temp[i] += cookies[ind];
            f(ind+1,cookies,temp,k,ans);
            temp[i] -= cookies[ind];
        }
    }
public:
    int distributeCookies(vector<int>& cookies, int k) {
        int ans = INT_MAX;
        vector<int> temp(k,0);
        f(0,cookies,temp,k,ans);
        return ans;
    }
};