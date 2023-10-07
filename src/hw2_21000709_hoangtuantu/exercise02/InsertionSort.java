package hw2_21000709_hoangtuantu.exercise02;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] numbers) {
        sort(numbers, true);
    }

    @Override
    public void sort(T[] numbers, boolean ascending) {
        for (int i = 1; i < numbers.length; i++){
            T key = numbers[i];
            int j = i - 1;
            while (j >= 0 && (ascending ? numbers[j].compareTo(key) >0 : numbers[j].compareTo(key) < 0)){
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }
    }

}
