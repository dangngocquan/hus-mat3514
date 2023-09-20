package hw2_21000699_dangngocquan.exercise009;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = scanner.nextInt();
        scanner.close();

        System.out.println(getNewIndex(h, t-1) + 1);
    }

    public static int getNewIndex(int[] h, int oldIndex) {
        int pivotValue = h[oldIndex];
        int pivotIndex = 0;
        for (int i = 0; i < oldIndex; i++) {
            if (h[i] <= pivotValue) pivotIndex++;
        }
        for (int i = oldIndex+1; i < h.length; i++) {
            if (h[i] < pivotValue) pivotIndex++;
        }
        return pivotIndex;
    }
}
