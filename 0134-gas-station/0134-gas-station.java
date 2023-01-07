class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int total_tank=0;
        int cur_tank=0;
        for(int i=0; i<gas.length; i++){
            total_tank += gas[i]-cost[i];
            cur_tank += gas[i]-cost[i];
            if(cur_tank<0){
                cur_tank = 0;
                start=i+1;
            }
        }
        return (total_tank<0)?-1:start;
    }
}