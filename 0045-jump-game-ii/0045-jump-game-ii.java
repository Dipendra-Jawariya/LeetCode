class Solution {
    private int f(int ind, int nums[],int dp[]) {
        if(ind >= nums.length-1) return 0;
        if(dp[ind] != -1) return dp[ind];
        int mini = (int) 1e9;
        for(int i = 1; i <= nums[ind]; i++) {
            int jump = 1 + f(ind + i,nums,dp);
            mini = Math.min(mini,jump);
        }
        return dp[ind] = mini;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return f(0 , nums,dp);
    }
}