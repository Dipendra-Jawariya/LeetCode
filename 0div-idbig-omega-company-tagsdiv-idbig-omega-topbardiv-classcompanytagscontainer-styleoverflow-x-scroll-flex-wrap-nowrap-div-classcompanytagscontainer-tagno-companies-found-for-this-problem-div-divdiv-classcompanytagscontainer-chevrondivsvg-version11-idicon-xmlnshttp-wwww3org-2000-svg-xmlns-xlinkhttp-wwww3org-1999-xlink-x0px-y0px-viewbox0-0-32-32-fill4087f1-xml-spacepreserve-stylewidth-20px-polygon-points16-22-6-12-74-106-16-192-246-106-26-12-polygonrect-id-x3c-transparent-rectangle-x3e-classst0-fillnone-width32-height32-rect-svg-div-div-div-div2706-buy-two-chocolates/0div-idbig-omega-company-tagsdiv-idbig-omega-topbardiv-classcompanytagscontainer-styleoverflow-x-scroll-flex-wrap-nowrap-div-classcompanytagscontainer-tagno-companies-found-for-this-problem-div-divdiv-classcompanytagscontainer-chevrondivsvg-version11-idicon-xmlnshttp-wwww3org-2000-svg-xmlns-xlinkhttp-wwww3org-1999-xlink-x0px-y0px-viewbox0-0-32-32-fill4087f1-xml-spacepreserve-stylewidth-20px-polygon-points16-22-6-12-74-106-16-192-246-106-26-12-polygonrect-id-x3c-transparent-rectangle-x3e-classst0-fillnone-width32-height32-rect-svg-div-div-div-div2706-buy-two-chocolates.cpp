class Solution {
public:
    int buyChoco(vector<int>& prices, int money) {
        sort(prices.begin(),prices.end());
        int sum = prices[0] + prices[1];
        
        if(money - sum >= 0) {
            return money - sum;
        } else {
            return money;
        }
    }
};