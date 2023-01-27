class Solution {
    private int f(int i,int j ,String s1, String s2,int dp[][]){
        if(j < 0) return 1;
        if(i < 0 ) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = f(i-1,j-1,s1,s2,dp)+ f(i-1,j,s1,s2,dp);
        }
        return dp[i][j] = f(i-1,j,s1,s2,dp); 
        
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n+1][m+1];
        // for(int row[] : dp) Arrays.fill(row,0);
        
        for(int i = 0; i<=n;i++){
            dp[i][0] = 1;
        }
        for(int j = 1;j <=m;j++){
            dp[0][j] = 0;
        }
        
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }
        return dp[n][m]; 
        
    }
}