package hw6_21000117_nguyenquochieu.exercise05;
import java.time.*;
public class TimeController implements Comparable{
    private LocalDate date;
    private LocalTime time;

    public TimeController(String date, String time) {
        getDate(date);
        getTime(time);
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    private void getDate(String dateString) {
        /*
        Date format: yyyy-mm-dd
         */
        String[] elements = dateString.split("-");
        int year = Integer.parseInt(elements[0]);
        Month month = Month.of(Integer.parseInt(elements[1]));
        int day = Integer.parseInt(elements[2]);
        this.date = LocalDate.of(year, month, day);
    }
    private void getTime(String timeString) {
        /*
        Time format: hh:mm:ss
         */
        String[] elements = timeString.split(":");
        int hour = Integer.parseInt(elements[0]);
        int minute = Integer.parseInt(elements[1]);
        int second = Integer.parseInt(elements[2]);
        this.time = LocalTime.of(hour, minute, second);
    }
    public int compareToPresent() {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        if (this.date.compareTo(dateNow) == 0) return this.time.compareTo(timeNow);
        else return this.date.compareTo(dateNow);
    }
    @Override
    public int compareTo(Object o) {
        TimeController timeController = (TimeController) o;
        if (this.date.compareTo(timeController.date) != 0) {
            return this.date.compareTo(timeController.date);
        } else return this.time.compareTo(timeController.time);
    }

    @Override
    public String toString() {
        return date.toString() + " " + time.toString();
    }
}
