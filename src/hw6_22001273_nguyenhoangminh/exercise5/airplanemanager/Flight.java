package hw6_22001273_nguyenhoangminh.exercise5.airplanemanager;

public class Flight {
    private String name;
    private int ID;
    private Time depart, arrive;

    public Flight(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public void setDepart(int hour, int minute) {
        this.depart = new Time(hour, minute);
    }

    public void setArrive(int hour, int minute) {
        this.arrive = new Time(hour, minute);
    }

    public Time getDepart() {
        return depart;
    }

    public Time getArrive() {
        return arrive;
    }

    @Override
    public String toString() {
        return name + ",ID:" + ID;
    }
}
