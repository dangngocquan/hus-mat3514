package hw2_21000699_dangngocquan.exercise002.service.generator;

public class Generator {
    // get random integer in [from, to-1]
    public static int randomInteger(int from, int to) {
        long range = (long) (to) - (long) (from);
        long random = (long) (Math.floor(Math.random() * range)) + (long) from;
        return (int) random;
    }

    // get an array has length n and value of each element in [from, to-1]
    public static Integer[] randomArray(int n, int from, int to) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) array[i] = randomInteger(from, to);
        return array;
    }
}
