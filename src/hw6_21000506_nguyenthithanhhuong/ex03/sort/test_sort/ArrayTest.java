package hw6_21000506_nguyenthithanhhuong.ex03.sort.test_sort;

public class ArrayTest {
    public static int createRandomNumber() {
        int min = 1;
        int max = 1000;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static Integer[] createRandomArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = createRandomNumber();
        }
        return array;
    }

    public static String printArray(Integer[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[array.length - 1]).append("]");
        return sb.toString();
    }
}
