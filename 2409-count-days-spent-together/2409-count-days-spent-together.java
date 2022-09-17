import java.time.LocalDate;
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        LocalDate d1 = LocalDate.of(2021,Integer.parseInt(arriveAlice.substring(0,2)),Integer.parseInt(arriveAlice.substring(3,5)));
        LocalDate d2 = LocalDate.of(2021,Integer.parseInt(leaveAlice.substring(0,2)),Integer.parseInt(leaveAlice.substring(3,5)));
        LocalDate d3 = LocalDate.of(2021,Integer.parseInt(arriveBob.substring(0,2)),Integer.parseInt(arriveBob.substring(3,5)));
        LocalDate d4 = LocalDate.of(2021,Integer.parseInt(leaveBob.substring(0,2)),Integer.parseInt(leaveBob.substring(3,5)));
        long aa = d1.toEpochDay(); //Alice arrive time
        long al  = d2.toEpochDay(); //Alice left time
        long ba = d3.toEpochDay(); //Bob arrive time 
        long bl  = d4.toEpochDay(); //Bob left time 
        if(al<ba || aa>bl) return 0; //No interaction days
        return (int) ((Math.min(al,bl)) - Math.max(aa,ba)+1);
        
    }
}