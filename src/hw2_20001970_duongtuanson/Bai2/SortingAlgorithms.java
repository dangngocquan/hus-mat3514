package hw2_20001970_duongtuanson.Bai2;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Random;
public class SortingAlgorithms {
    public static <T> void bubbleSort(T[] arr, Comparator<? super T> c) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (c.compare(arr[j], arr[j+1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static <T> void selectionSort(T[] arr, Comparator<? super T> c) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (c.compare(arr[j], arr[min_idx]) < 0)
                    min_idx = j;
            T temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static <T> void insertionSort(T[] arr, Comparator<? super T> c) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i-1;
            while (j >= 0 && c.compare(arr[j], key) > 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static <T> void mergeSort(T[] arr, Comparator<? super T> c) {
        int n = arr.length;
        if (n < 2)
            return;
        int mid = n/2;
        T[] left = (T[]) new Object[mid];
        T[] right = (T[]) new Object[n-mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int i = mid; i < n; i++)
            right[i-mid] = arr[i];
        mergeSort(left, c);
        mergeSort(right, c);
        merge(arr, left, right, c);
    }
    public static <T> void merge(T[] arr, T[] left, T[] right, Comparator<? super T> c) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;
        while (i < nL && j < nR) {
            if (c.compare(left[i], right[j]) <= 0) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static <T> void quickSort(T[] arr, Comparator<? super T> c) {
        int n = arr.length;
        quickSort(arr, 0, n-1, c);
    }

    public static <T> void quickSort(T[] arr, int low, int high, Comparator<? super T> c) {
        if (low < high) {
            int pi = partition(arr, low, high, c);
            quickSort(arr, low, pi-1, c);
            quickSort(arr, pi+1, high, c);
        }
    }

    public static <T> int partition(T[] arr, int low, int high, Comparator<? super T> c) {
        T pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++)
            if (c.compare(arr[j], pivot) < 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        T temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu: ");
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = rd.nextInt(100000);
        System.out.println("Mang ban dau: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("bubbleSort: ");
        bubbleSort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // o1 - o2
            }
        });
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("selectionSort: ");
        selectionSort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // o1 - o2
            }
        });
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("insertionSort: ");
        insertionSort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // o1 - o2
            }
        });
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("mergeSort: ");
        mergeSort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // o1 - o2
            }
        });
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("quickSort: ");
        quickSort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2); // o1 - o2
            }
        });
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        sc.close();
    }
}
