package hw2_20001970_duongtuanson.Bai4;
import java.util.Scanner;
public class bai42 {
    //insertionSort
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
        System.out.println("insertionSort: ");
        insertionSort(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
