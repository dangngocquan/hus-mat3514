package hw1_21000506_nguyenthithanhhuong.ex5;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//Project P-1.26 (M.Goodrich)
public class Exercise05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> lineList = new ArrayList<>();

        String lineItem = "";

        System.out.println("Input:");

        while (true) {
            lineItem = sc.nextLine();
            if (lineItem == null || lineItem.isEmpty()) break;
            lineList.add(lineItem);
        }

        sc.close();

        System.out.println("Output...");
        for (int i  = lineList.size() - 1; i >= 0; i--) {
            System.out.println(lineList.get(i));
        }
    }
}
