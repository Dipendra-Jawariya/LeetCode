class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int[] toAdd = newInterval;
        for(int i =0;i<intervals.length;i++){
            //end < start
            if(intervals[i][1] < toAdd[0]){
                ans.add(intervals[i]);
                //start > end
            }else if(intervals[i][0] > toAdd[1]){
                ans.add(toAdd);
                toAdd = intervals[i];
                //if there is an overlapping
            }else{
                toAdd = new int[]{Math.min(intervals[i][0],toAdd[0]),Math.max(intervals[i][1],toAdd[1])};
            }
        }
       
            ans.add(toAdd);
        return ans.toArray(new int[ans.size()][2]);
    }
}