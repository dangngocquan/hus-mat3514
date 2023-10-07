package hw2_21000709_hoangtuantu.exercise02;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
    private int minIndex(T[] numbers,int start){
        int index = start;
        for (int i = start + 1; i < numbers.length; i++){
            if (numbers[index].compareTo(numbers[i]) > 0){
                index = i;
            }
        }
        return index;
    }

    private int maxIndex(T[] numbers, int start){
        int index = start;
        for (int i = start + 1; i < numbers.length; i++){
            if (numbers[index].compareTo(numbers[i]) < 0){
                index = i;
            }
        }
        return index;
    }

    @Override
    public void sort(T[] numbers){
        sort(numbers, true);
    }

    @Override
    public void sort(T[] numbers, boolean ascending){
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = ascending ? minIndex(numbers, i) : maxIndex(numbers, i);
            if (i != index){
                T number = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = number;
            }
        }
    }
}
