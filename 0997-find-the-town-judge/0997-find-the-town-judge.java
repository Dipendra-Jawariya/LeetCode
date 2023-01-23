class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1 && trust.length == 0) return 1;
        int count[] = new int[n+1];
        for(int it[]: trust){
            count[it[0]]--;
            count[it[1]]++;
        }
        for(int i = 0; i <= n; i++){
            if(count[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}