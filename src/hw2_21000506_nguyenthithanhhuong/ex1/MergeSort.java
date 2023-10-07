package hw2_21000506_nguyenthithanhhuong.ex1;

public class MergeSort {
    public static int countCompare = 0;

    public static void mergeSort(int[] array) {
        System.out.print("Input array: ");
        System.out.println(CreateArray.printArray(array));

        mergeSort0(array, 0, array.length - 1);

        System.out.print("Array after sort: ");
        System.out.println(CreateArray.printArray(array));


        System.out.println("Numbers of comparison: " + countCompare);
    }

    public static void mergeSort0(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort0(array, low, mid);
            System.out.printf("After sort array[%d,%d]: ", low, mid);
            System.out.println(CreateArray.printArray(array));

            mergeSort0(array, mid + 1, high);
            System.out.printf("After sort array[%d,%d]: ", mid + 1, high);
            System.out.println(CreateArray.printArray(array));

            merge(array, low, mid, high);
            System.out.printf("After merge array[%d,%d]: ", low, high);
            System.out.println(CreateArray.printArray(array));
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 =  high - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0; i < n1; i++){
            L[i] = array[low + i];
        }
        for (j = 0; j < n2; j++){
            R[j] = array[mid + 1+ j];
        }
        i = 0;
        j = 0;
        k = low;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            countCompare++;
        }
        while (i < n1){
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2){
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort1(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort1(array, low, mid);

            mergeSort1(array, mid + 1, high);

            merge1(array, low, mid, high);
        }
    }

    public static void merge1(int[] array, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 =  high - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0; i < n1; i++){
            L[i] = array[low + i];
        }
        for (j = 0; j < n2; j++){
            R[j] = array[mid + 1+ j];
        }
        i = 0;
        j = 0;
        k = low;
        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2){
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static long time(int[] array) {
        long start =  System.currentTimeMillis();

        mergeSort1(array, 0, array.length -1);

        long end = System.currentTimeMillis();
        return end - start;
    }
}
