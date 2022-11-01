class Solution {
    public int[] findBall(int[][] grid) {
        int col = grid.length;
        int row = grid[0].length;
        int ans[] = new int[row];
        for(int i = 0; i < row; i++){
            int cpos = i;
            int npos = -1;
            for(int j = 0; j < col; j++){
                npos = cpos+grid[j][cpos];
                if(npos < 0 || npos >= row || grid[j][npos] != grid[j][cpos]){
                    cpos = -1;
                    break;
                }
                cpos = npos;
            }
            ans[i] =cpos;
        }
        return ans;
    }
}