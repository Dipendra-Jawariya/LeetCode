class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
//          (y2 - y1) * (x2 - x1)
         int R2  = (by2 - by1) * (bx2 - bx1);
         int R1  = (ay2 - ay1) * (ax2 - ax1);
        int cx1 = Math.max(ax1,bx1) , cy1 = Math.max(ay1,by1);
        int cx2 = Math.min(ax2, bx2) , cy2 = Math.min(ay2,by2);
        int xoverlap = cx2- cx1;
        int yoverlap = cy2 - cy1;
        int overlap = 0;
         if (xoverlap > 0 && yoverlap > 0){
            overlap = xoverlap * yoverlap;     
         }
        
        return R1 + R2 - overlap;
    }
}