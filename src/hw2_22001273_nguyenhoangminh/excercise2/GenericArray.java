package hw2_22001273_nguyenhoangminh.excercise2;

public class GenericArray<T extends Comparable<T>> {
    // T là một đối tượng thuộc Comparable
    T[] array;
    public GenericArray(T[] array) { this.array = array; }
    public T[] getArray() { return array; }
}
