package hw2_22001273_nguyenhoangminh.excercise1;
public class Sort {
    static int numOfCompare = 0, numOfSwap = 0;

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void bubbleSort2(int[] a, int N) {
        for (int i=0; i<N; i++) {
            boolean is_sorted = true;
            for(int j=1; j<N-i; j++) {
                if (a[j-1]>a[j]) {
                    swap(a, j, j-1);
                    is_sorted = false;
                    // GenerateArray.printArray(a);
                    numOfSwap++;
                } 
                numOfCompare++; 
            }
            if(is_sorted) return;
        }
    }
    public static void selectionSort(int[] a, int N) {
        for (int i=N-1; i>=1; --i) {    // i start from the end of the array
            int maxIndex = i;
            // find the max index
            for (int j=0; j<i; ++j) {
                if (a[j] >= a[maxIndex]){       
                    maxIndex = j;
                }
                numOfCompare++; 
            }
            // push the max index to the end of the array
            swap(a, i, maxIndex);
            GenerateArray.printArray(a);
            numOfSwap++; 
        }
    }
    public static void insertionSort(int[] a, int N) {
        for (int i=1; i<N; ++i) {
            int pickup = a[i];      // pick up an elements
            int j;
            for (j=i-1; j>=0 && a[j]>pickup; --j) {     // compare element with index j
                a[j+1] = a[j];      // if the index j is larger than element, shift the index j to the next index
                numOfCompare++;
            }
            a[j+1] = pickup;        // if index j is smaller or equal to the element, the element is place next to j
            GenerateArray.printArray(a);
            numOfSwap++;
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        int pivotIndex;
        if (low<high) {
            pivotIndex = partition(a, low, high);
            // recursive
            quickSort(a, low, pivotIndex-1);
            quickSort(a, pivotIndex+1, high);
        }
    }
    static int partition(int[] a, int i, int j) {
        int p =a[i];
        int m = i;
        for (int k=i+1; k<=j; ++k) {
            if (a[k]<p) {
                ++m;
                swap(a, k, m);
            }
        }
        swap(a, i, m);
        return m;
    }
    public static void mergeSort(int[] a, int low, int high) {
        if (low<high) {
            int mid = (low+high)/2;
            // recursive
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }
    static void merge(int[] a, int low, int mid, int high) {
        int n = high-low+1;     // length of array
        int[] b = new int[n];   // temp array to store result
        int left = low, right = mid+1, bIndex = 0;

        while (left<=mid && right<=high) {
            if(a[left] <= a[right]) {
                b[bIndex++] = a[left++];
            } else {
                b[bIndex++] = a[right++];
            }
        }

        while (left <= mid) {
            b[bIndex++] = a[left++];
        }
        while (right <= high) {
            b[bIndex++] = a[right++];
        }
        for (int k=0; k<n; k++) {
            a[low+k] = b[k];
        }
    }
}
