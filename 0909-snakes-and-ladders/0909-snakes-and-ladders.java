class Pair{
    int val;
    int steps;
    Pair(int val,int steps){
        this.val = val;
        this.steps = steps;
    }
}
class Solution {
    private int[] findCoordinates(int curr,int n){
        int r = n - ( curr  - 1)/n - 1;
        int c = (curr - 1) % n;
        if(r % 2 == n % 2){
            return new int[]{r,n - 1 - c};
        }else{
            return new int[]{r,c};
        }
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        // int step = 0;
        Queue<Pair> q = new LinkedList<Pair>();
        boolean vis[][] = new boolean[n][n];
        q.add(new Pair(1,0));
        vis[n-1][0]= true;
        while(!q.isEmpty()){
            int size = q.size();
            
            // for(int i = 0;i < size; i++){
                int val = q.peek().val;
                int steps = q.peek().steps;
                q.remove();
                
                if(val == n * n) return steps;
                for(int k = 1; k <= 6; k++){
                    if( k + val > n * n ) break;
                    int pos[] = findCoordinates(k+val,n);
                    int r = pos[0];
                    int c = pos[1];
                    if(vis[r][c] == true){
                        continue;
                    }
                    vis[r][c] = true;
                    if(board[r][c] == -1){
                        q.add(new Pair(k+val,steps+1));
                    }else{
                        q.add(new Pair(board[r][c],steps+1));
                    }
                }
            // }
        }
        return -1;
    }
}