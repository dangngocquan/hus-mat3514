package hw3_20000550_duongduyhieu.Bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            numbers.add(x);
        }

        int targetIndex = scanner.nextInt();
        int targetValue = numbers.get(targetIndex);

        List<Integer> resultList = new ArrayList<>();
        for (int number : numbers) {
            if (number <= targetValue) {
                resultList.add(number);
            }
        }

        for (Integer result : resultList) {
            System.out.print(result + " ");
        }
    }
}
