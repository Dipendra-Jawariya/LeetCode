class Solution {
    private void solve(int col,int[] res,char board[][],int[] leftRow,int[] upperDiagonal,int[] lowerDiagonal){
        if(col==board.length){
            res[0] += 1;
            return;
        }
        for(int row =0;row<board.length;row++){
            if(leftRow[row]==0 && upperDiagonal[board.length-1+col-row]==0 && lowerDiagonal[row+col]==0){
                board[row][col]= 'Q';
                leftRow[row] = 1;
                upperDiagonal[board.length-1+(col-row)] = 1;
                lowerDiagonal[row+col] = 1;
                solve(col+1,res,board,leftRow,upperDiagonal,lowerDiagonal);
                 board[row][col]= '.';
                leftRow[row] = 0;
                upperDiagonal[board.length-1+(col-row)] = 0;
                lowerDiagonal[row+col] = 0;
            }
        }
    }
    public int totalNQueens(int n) {
        int res[] ={0};
        char board[][] = new char[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2*n-1];
        int lowerDiagonal[] = new int[2*n-1];
        solve(0,res,board,leftRow,upperDiagonal,lowerDiagonal);
        return res[0];
    }
}