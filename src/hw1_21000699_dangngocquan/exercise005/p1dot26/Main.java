package hw1_21000699_dangngocquan.exercise005.p1dot26;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter something ... (or press enter with empty line to quit)");
        List<String> lines = new LinkedList<>();
        String line = "";
        while (true) {
            line = scanner.nextLine();
            if (line.isBlank()) break;
            lines.add(line);
        }
        scanner.close();

        // Print lines in reserved order
        System.out.println("Lines in reserved order: ");
        for (int i = lines.size()-1; i >= 0; i--) {
            System.out.println(lines.get(i));
        }
    }
}
