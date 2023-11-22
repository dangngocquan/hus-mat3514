package hw6_21000709_hoangtuantu.excercise03.service;

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
    @Override
    public void sort(T[] numbers){
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = minIndex(numbers, i);
            if (i != index){
                T number = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = number;
            }
        }
    }
}
