class Solution {
    
    private boolean recMemo(int[] nums,int i ,int[] dp){
        if(i == nums.length-1) return true;
        // if(i > nums.length) return false;
        if(dp[i]!=-1) return true;
        for(int j =1;j<=nums[i];j++){
            if(recMemo(nums,i+j,dp)){
                dp[i] = 1;
                return true;
            }
        }
        return false;
    }
    private boolean tabulation(int nums[]){
        int n = nums.length -1;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[n] = 1;
        for(int i = n-1;i>=0;i--){
            for(int j =1;j<=nums[i];j++){
                if(dp[i+j] == 1){
                    dp[i] =1;
                    break;
                }
            }
        }
        return dp[0] == -1 ? false : true;
    }
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        // return recMemo(nums, 0, dp);
        return tabulation(nums);
    }
}