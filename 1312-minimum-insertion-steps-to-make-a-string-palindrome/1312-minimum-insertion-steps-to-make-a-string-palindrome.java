class Solution {
    private int longPalindromString(int ind1,int ind2,String s1,String s2,int dp[][]) {
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + longPalindromString(ind1 - 1,ind2 - 1,s1,s2,dp);
        }
        return dp[ind1][ind2] = Math.max(
                        longPalindromString(ind1 - 1,ind2,s1,s2,dp),
                        longPalindromString(ind1,ind2 - 1,s1,s2,dp)
                                        );
    }
    public int minInsertions(String s) {
        int n = s.length();
         StringBuilder s1 = new StringBuilder();
        s1.append(s);
        s1.reverse();
        int dp[][] = new int[n][n];
        for(int it[] : dp) {
            Arrays.fill(it,-1);
        }
        return n - longPalindromString(n-1,n-1,s,s1.toString(),dp);
    }
}