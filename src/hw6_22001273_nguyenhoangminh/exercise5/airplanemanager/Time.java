package hw6_22001273_nguyenhoangminh.exercise5.airplanemanager;

public class Time implements Comparable<Time>{
    private int hour, minute;

    public Time(int hour, int minute) {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) throw new IllegalArgumentException("Invalid time");
        this.hour = hour;
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setTime(int hour, int minute) {
        this.minute = minute;
        this.hour = hour;
    }

    @Override
    public int compareTo(Time another) {
        if (this.hour < another.hour) {
            return -1;
        } else if (this.hour == another.hour) {
            if (this.minute < another.minute) {
                return -1;
            } else if (this.minute == another.minute) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        if (minute == 0) return this.hour + ":" + this.minute + "0";
        return this.hour + ":" + this.minute;
    }
}
