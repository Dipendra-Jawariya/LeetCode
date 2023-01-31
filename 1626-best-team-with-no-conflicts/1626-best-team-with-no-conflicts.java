class Solution {
   private int f(int ind,int team[][],int prev,int dp[][]){
       if(ind == team.length){
           return 0;
       }
       if(dp[prev+1][ind] != -1){
           return dp[prev+1][ind];
       }
       int notTake=0;
        int take= 0;
       if(prev == -1 || team[prev][1] <= team[ind][1]){
          return dp[prev+1][ind] = Math.max(team[ind][1] + f(ind+1,team,ind,dp),
                          f(ind+1,team,prev,dp));
       }
       return dp[prev+1][ind] = f(ind+1,team,prev,dp);
   }
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int index = 0;
        int [][]  team = new int[n][2];
        for(int i =0;i<n;i++){
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        Arrays.sort(team, (a,b) -> a[0] == b[0] ?  a[1] - b[1] : a[0] - b[0]);
        return f(0,team,-1,dp);
    }
}