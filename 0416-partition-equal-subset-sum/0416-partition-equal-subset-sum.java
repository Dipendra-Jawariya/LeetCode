class Solution {
    private boolean f(int ind,int nums[],int target,int dp[][]){
        if(target == 0){
            return true;
        }
        // if(dp[0][nums[0]]){
        //     return true'
        // }
        if(ind == 0) return target == nums[0];
        if(dp[ind][target] != -1){
            return dp[ind][target] == 0?false:true;
        }
        boolean not_take = f(ind-1,nums,target,dp);
        boolean take =false;
        if(nums[ind] <= target){
            take =  f(ind-1,nums,target - nums[ind],dp);
        }
        dp[ind][target] = not_take || take ?1:0;
        return take || not_take;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i =0;i<nums.length;i++){
            totalSum += nums[i];
        }
        int n = nums.length;
        if(totalSum % 2==0){
            int target = totalSum / 2;
            int dp[][] = new int[n][target+1];
            for(int rows[]:dp){
                Arrays.fill(rows , -1);
            }
            return f(n-1,nums,target,dp);    
        }else{
            return false;
        }
        
    }
}