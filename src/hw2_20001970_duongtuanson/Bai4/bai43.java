package hw2_20001970_duongtuanson.Bai4;
import java.util.Scanner;
public class bai43 {
    //selectionSort
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
        System.out.println("selectionSort: ");
        selectionSort(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        int min_idx;
        for (int i = 0; i < n - 1; i++){
            min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
