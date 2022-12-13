class Solution {
   public int minFallingPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length + 1][grid[0].length];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++)
            ans = Math.min(ans, (helperRecursiveDP(grid, dp, 0, i, grid.length)));
			// finding answers for each column of first row seperatly and storing the minimum value in variable ans 
        return ans;
    }
	
// helper function which computes the result for each column in row 1
private int helperRecursiveDP(int[][] grid, Integer[][] dp, int i, int j, int n) {
        if (j >= n || j < 0) // base-case 1
            return (int) Math.pow(10, 7);

        if (i == n - 1)
            return grid[i][j]; // base-case 2

        if (dp[i][j] != null)
            return dp[i][j]; // avoiding repetitive steps by returning previously calculated ans
		
		// Traversing path according to the question
        int x = grid[i][j] + helperRecursiveDP(grid, dp, i + 1, j, n);
        int y = grid[i][j] + helperRecursiveDP(grid, dp, i + 1, j + 1, n);
        int z = grid[i][j] + helperRecursiveDP(grid, dp, i + 1, j - 1, n);

        int ans = Math.min(x, Math.min(y, z)); // finding min of values returned by three traversed paths
        dp[i][j] = ans;

        return ans;
    }
}