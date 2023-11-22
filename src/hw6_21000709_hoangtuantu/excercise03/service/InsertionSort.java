package hw6_21000709_hoangtuantu.excercise03.service;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] numbers) {
        for (int i = 1; i < numbers.length; i++){
            T key = numbers[i];
            int j = i - 1;
            while (j >= 0 && (numbers[j].compareTo(key) >0)){
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }
    }

}
