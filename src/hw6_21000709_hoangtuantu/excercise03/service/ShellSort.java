package hw6_21000709_hoangtuantu.excercise03.service;

public class ShellSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] numbers) {
        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < numbers.length; i++) {
                T temp = numbers[i];
                int j;
                for (j = i; j >= gap && (numbers[j - gap].compareTo(temp) > 0); j -= gap) {
                    numbers[j] = numbers[j - gap];
                }

                if (j != i){
                    numbers[j] = temp;
                }
            }
        }
    }
}
