import java.time.LocalDate;
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return (int) Math.abs(LocalDate.parse(date1).toEpochDay() - LocalDate.parse(date2).toEpochDay());
    }
}