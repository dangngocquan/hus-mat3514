package hw2_20001970_duongtuanson.Bai6;
import java.util.Scanner;
public class QuickSelect {
    // Số nhỏ thứ k trong mảng arr
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.print("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.print("Nhập số nhỏ thứ k: ");
        int k = scan.nextInt();
        System.out.println("Số nhỏ thứ " + k + " là: " + quickSelect(arr, 0, n - 1, k));
        scan.close();
    }

    public static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        int pivotIndex = partition(arr, left, right);
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i , j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
