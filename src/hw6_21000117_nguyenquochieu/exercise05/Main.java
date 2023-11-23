package hw6_21000117_nguyenquochieu.exercise05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventController controller = addSampleTest();
        System.out.println("Next event: " + controller.getNextEvent());

    }
    public static boolean checkPath(String path) {
        if (path.contains("C:") || path.contains("D:")) {
            return true;
        } else {
            System.out.println("Path to \"data.csv\" should be an absolute path");
            System.exit(1);
            return false;
        }
    }
    public static EventController addSampleTest() {
        EventController controller = new EventController();
        List<List<String>> records = new ArrayList<>();
        String path = "D:\\Study\\Java\\with_ittelliJ\\hus-mat3514\\src\\hw6_21000117_NguyenQuocHieu\\exercise05\\data.csv";
        checkPath(path);
        boolean isHeadRow = true;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (!isHeadRow) records.add(Arrays.asList(values));
                isHeadRow = false;
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        for (List<String> record : records) {
            String id = record.get(0);
            String destination = record.get(1);
            String date = record.get(2);
            String time = record.get(3);
            Event event = new Event(new TimeController(date, time), id, destination);
            controller.addEvent(event);
        }
        return controller;
    }
}
