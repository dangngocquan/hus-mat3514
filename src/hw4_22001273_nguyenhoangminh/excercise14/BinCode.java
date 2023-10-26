package hw4_22001273_nguyenhoangminh.excercise14;

import hw4_22001273_nguyenhoangminh.excercise2.LinkedListStack;

public class BinCode {
    public static int toBin(int n) {
        LinkedListStack<Integer> buffer = new LinkedListStack<>();


        while (n > 0) {
            buffer.push(n % 2);
            n /= 2;
        }

        int size = buffer.size();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < size; i++) {
            num.append(buffer.pop());
        }

        String bin = num.toString();

        return Integer.parseInt(bin);
    }

    public static void main(String[] args) {
        System.out.println(toBin(13));
    }
}
