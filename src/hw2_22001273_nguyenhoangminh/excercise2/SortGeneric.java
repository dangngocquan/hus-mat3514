package hw2_22001273_nguyenhoangminh.excercise2;

public class SortGeneric<T extends Comparable<T>> implements Comparable<T>{
    // T là một đối tượng thuộc Comparable
    static int numOfCompare = 0, numOfSwap = 0;
    T[] array;    // Array of parametered type

    @Override
    public int compareTo(T o) { return compareTo(o); }

    void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void bubbleSort2(T[] a, int N) {
        for (int i=0; i<N; i++) {
            boolean is_sorted = true;
            for(int j=1; j<N-i; j++) {
                if (a[j-1].compareTo(a[j])>0) {
                    swap(a, j, j-1);
                    is_sorted = false;
                    numOfSwap++;
                } 
                numOfCompare++; 
            }
            if(is_sorted) return;
        }
    }
    public void selectionSort(T[] a, int N) {
        for (int i=N-1; i>=1; --i) {    // i start from the end of the array
            int maxIndex = i;
            // find the max index
            for (int j=0; j<i; ++j) {
                if (a[j].compareTo(a[maxIndex]) >= 0){       
                    maxIndex = j;
                }
                numOfCompare++; 
            }
            // push the max index to the end of the array
            swap(a, i, maxIndex);
            numOfSwap++; 
        }
    }
    public void insertionSort(T[] a, int N) {
        for (int i=1; i<N; ++i) {
            T pickup = a[i];      // pick up an Ts
            int j;
            for (j=i-1; j>=0 && a[j].compareTo(pickup)>0; --j) {     // compare T with index j
                a[j+1] = a[j];      // if the index j is larger than T, shift the index j to the next index
                numOfCompare++;
            }
            a[j+1] = pickup;        // if index j is smaller or equal to the T, the T is place next to j
            numOfSwap++;
        }
    }

    public void quickSort(T[] a, int low, int high) {
        int pivotIndex;
        if (low<high) {
            pivotIndex = partition(a, low, high);
            // recursive
            quickSort(a, low, pivotIndex-1);
            quickSort(a, pivotIndex+1, high);
        }
    }
    int partition(T[] a, int i, int j) {
        T p =a[i];
        int m = i;
        for (int k=i+1; k<=j; ++k) {
            if (a[k].compareTo(p)<0) {
                ++m;
                swap(a, k, m);
            }
        }
        swap(a, i, m);
        return m;
    }
}
