class Solution {
    private int fMemo(int ind1,int ind2,String s1,String s2,int dp[][]) {
        if(ind1 < 0) return ind2+1;
        if(ind2 < 0) return ind1+1;
        
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        
        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return 0 + fMemo(ind1-1,ind2-1,s1,s2,dp);
        }
        return dp[ind1][ind2] = Math.min( 1 + fMemo(ind1,ind2-1,s1,s2,dp),
                        Math.min(1 + fMemo(ind1-1,ind2,s1,s2,dp),
                        1 + fMemo(ind1-1,ind2-1,s1,s2,dp))
                       );
    }
        
        
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        for(int it[] : dp) Arrays.fill(it,-1);
        return fMemo(n-1,m-1,word1,word2,dp);
    }
}