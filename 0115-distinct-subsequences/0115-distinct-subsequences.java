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
        int dp[][] = new int[n][m];
        for(int row[] : dp) Arrays.fill(row,-1);
        return f(n-1,m-1,s,t,dp);
    }
}