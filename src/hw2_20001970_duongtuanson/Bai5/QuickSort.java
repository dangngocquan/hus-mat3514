package hw2_20001970_duongtuanson.Bai5;
import java.util.Scanner;
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Mang ban dau: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("quickSort: ");
        quickSort(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

    }
    public static void quickSort(int[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi+1, high);
        }
    }
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
