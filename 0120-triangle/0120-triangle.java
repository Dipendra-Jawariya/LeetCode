class Solution {
    private int f(int i, int j ,int n,  List<List<Integer>> triangle,int dp[][]) {
        if( i == n-1) {
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + f(i+1,j,n,triangle,dp);
        int diagonal = triangle.get(i).get(j) + f(i+1,j+1,n,triangle,dp);
        return dp[i][j] = Math.min(down ,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // int m = triangle[0].size();
        int dp[][] = new int[n][201];
        for(int it[] : dp) Arrays.fill(it,0);
        
        for(int j = 0; j < n; j++ ) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i = n-2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down , diagonal);
            }
        }
        return dp[0][0];
    }
}