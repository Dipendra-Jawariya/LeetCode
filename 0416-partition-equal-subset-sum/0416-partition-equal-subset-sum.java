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
    private boolean tabulation(int[] nums,int target){
        int n = nums.length;
        boolean dp[][]= new boolean[n][target+1];
        
        //base case
        for(int i =0;i<n;i++){
            dp[i][0] = true;
        }
        if(nums[0] == target) dp[0][target] = true;
        
        for(int ind =1;ind<n;ind++){
            for(int tar = 1;tar<= target; tar++){
                    boolean not_take = dp[ind-1][target];
                    boolean take =false;
                    if(nums[ind] <= target){
                    take =  dp[ind-1][target - nums[ind]];
                    }           
                    dp[ind][target] = not_take || take;
            }
        }
        return dp[n-1][target];
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
            return f(n-1,nums,target,dp);  //memoization + recursion
            //tabulation
            // return tabulation(nums,target);
        }else{
            return false;
        }
        
    }
}