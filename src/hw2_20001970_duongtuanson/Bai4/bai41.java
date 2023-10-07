package hw2_20001970_duongtuanson.Bai4;
import java.util.Scanner;
public class bai41 {
    //bubbleSort
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
        System.out.println("bubbleSort: ");
        bubbleSort(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        int temp = 0;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }
}
