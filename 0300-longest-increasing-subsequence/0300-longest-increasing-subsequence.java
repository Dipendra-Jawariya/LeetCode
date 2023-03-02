class Solution {
    private int f(int ind,int prev_ind,int nums[],int dp[][]) {
        if(ind == nums.length - 1) return 0;
        if(dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1];
        int len = 0 + f(ind+1,prev_ind,nums,dp);
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]) {
            len = Math.max(len, 1 + f(ind+1,ind,nums,dp));
        }
        return dp[ind][prev_ind+1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int dp[][] = new int[n+1][n+1];
        // for(int it[] : dp) {
        //     Arrays.fill(it,0);
        // }
        
        int nextRow[] = new int[n+1];
        int currRow[] = new int[n+1];
        
        
        for(int ind = n-1; ind >=0; ind--) {
            for(int prev_ind = ind-1;prev_ind >=-1; prev_ind--) {
                int len = 0 + nextRow[prev_ind+1];
                if(prev_ind == -1 || nums[ind] > nums[prev_ind]) {
                    len = Math.max(len, 1 + nextRow[ind+1]);
                }
                currRow[prev_ind+1] = len;
           }
            nextRow = currRow;
        }
        return currRow[-1+1];
    } 
}