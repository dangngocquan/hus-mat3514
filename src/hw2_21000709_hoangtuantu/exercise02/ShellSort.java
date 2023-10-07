package hw2_21000709_hoangtuantu.exercise02;

public class ShellSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] numbers) {
        sort(numbers, true);
    }

    @Override
    public void sort(T[] numbers, boolean ascending) {
        for (int gap = numbers.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < numbers.length; i++) {
                T temp = numbers[i];
                int j;
                for (j = i; j >= gap && (ascending ? numbers[j - gap].compareTo(temp) > 0 : numbers[j - gap].compareTo(temp) < 0); j -= gap) {
                    numbers[j] = numbers[j - gap];
                }

                if (j != i){
                    numbers[j] = temp;
                }
            }
        }
    }
}
