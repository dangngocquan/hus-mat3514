package hw4_21000117_nguyenquochieu.practice08;

public class Main {
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        int param = obj.ping(1);
        int param1 = obj.ping(2);
        int param2 = obj.ping(3);
        int param3 = obj.ping(3001);
        int param4 = obj.ping(3002);
        System.out.println(param2);
    }
}
