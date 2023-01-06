class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for(int i = 0;i < costs.length; i++){
            if(coins == 0 ) break;
            if(coins < costs[i]){
                continue;
            }else if(costs[i] <= coins){
                count ++;
                coins -= costs[i];
            }
        }
        return count;
    }
}