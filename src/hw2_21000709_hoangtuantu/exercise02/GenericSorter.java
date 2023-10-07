package hw2_21000709_hoangtuantu.exercise02;


public class GenericSorter<T> {
    public GenericSorter() {
    }



    public <T extends Comparable<T>> T[] sort(T[] numbers, Sort<T> sort, boolean ascending){
        SortSolution<T> solution = new SortSolution<>(sort, numbers, ascending); // Using Sort
        solution.sort(); // Sorting Array
        return numbers;
    }

    public <T extends Comparable<T>> T[] sort(T[] numbers, Sort<T> sort){
        return sort(numbers, sort, true);
    }
}
