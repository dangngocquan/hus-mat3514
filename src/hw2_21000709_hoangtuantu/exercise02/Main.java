package hw2_21000709_hoangtuantu.exercise02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static Random   random  = new Random();
    public static Double[] initializeDoubleArray(int size, double max){
        Double[] numbers = new Double[size];
        for (int i = 0; i < size; i++){
            numbers[i] = max * random.nextDouble();;
        }
        return numbers;
    }

    public static String[] initializeStringArray(int size, int stringSize){
        String[] randomArray = new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder randomString = new StringBuilder();
            for (int j = 0; j < stringSize; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random alphabet character.
                randomString.append(randomChar);
            }
            randomArray[i] = randomString.toString();
        }
        return randomArray;
    }
    public static <T extends Comparable<T>> boolean allSame(List<T[]> arrayNumbers){
        for (int i = 0; i < arrayNumbers.size() - 1; i++) {
            for (int j = i + 1; j < arrayNumbers.size(); j++) {
                if (! Arrays.equals(arrayNumbers.get(i), arrayNumbers.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printDoubleArray(Double[] array){
        for (double number: array){
            System.out.printf("%.2f, ", number);
        }
        System.out.println();
    }

    public static void printStringArray(String[] array){
        for (String number: array){
            System.out.printf("%s, ", number);
        }
        System.out.println();
    }
    public static <T extends Comparable<T>> List<T[]> sort(T[] array){
        GenericSorter<T> sorter = new GenericSorter<>();
        Sort<T>[] sorts = new Sort[]{new BubbleSort<T>(), new InsertionSort<T>(), new SelectionSort<T>(), new ShellSort<T>(), new QuickSort<T>(), new MergeSort<T>() };

        List<T[]> store = new ArrayList<>();
        for (Sort<T> sort: sorts){
            T[] result = Arrays.copyOf(array, array.length); // copy array to another array
            sorter.sort(result, sort);
            store.add(result);
        }
        return store;
    }

    public static <T extends Comparable<T>> void main(String[] args) {
        int size = 100;
        int sizeString  = 10;
        Double[] doubleArray = initializeDoubleArray(size, Math.pow(10, 6));
        String[] stringArray = initializeStringArray(size, sizeString);

        List<Double[]> doubles = sort(doubleArray);
        if (allSame(doubles)){
            System.out.println("Array after sort: ");
            printDoubleArray(doubles.get(0));
        }else {
            System.out.println("Oops! some sorting way is error!");
        }

        List<String[]> strings = sort(stringArray);
        if (allSame(strings)){
            System.out.println("Array after sort: ");
            printStringArray(strings.get(0));
        }else {
            System.out.println("Oops! some sorting way is error!");
        }
    }
}
