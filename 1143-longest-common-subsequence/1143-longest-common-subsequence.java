class Solution {
    private int subsequence(String text1,String text2,int n,int m,int dp[][]){
        if(n==0 || m ==0){
            return 0;
        }
        if(dp[n-1][m-1] !=-1){
            return dp[n-1][m-1];
        }
        if(text1.charAt(n-1) == text2.charAt(m-1)){ 
            System.out.println(text1.charAt(n-1));
            return dp[n-1][m-1] = 1 + subsequence(text1,text2,n-1,m-1,dp);
        }
        return dp[n-1][m-1]= 0 + Math.max(subsequence(text1,text2,n-1,m,dp),subsequence(text1,text2,n,m-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        return subsequence(text1,text2,n ,m,dp);
    }
}