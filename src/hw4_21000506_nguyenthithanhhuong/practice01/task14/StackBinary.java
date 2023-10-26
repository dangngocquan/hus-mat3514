package hw4_21000506_nguyenthithanhhuong.practice01.task14;

import hw4_21000506_nguyenthithanhhuong.ex02.ArrayStack;
import hw4_21000506_nguyenthithanhhuong.ex02.StackInterface;
import hw4_21000506_nguyenthithanhhuong.practice01.task13.ReverseString;

public class StackBinary {
    public static String stackBinary(int num) {
        StringBuilder sb = new StringBuilder("");
        while (num > 0) {
            sb.append(num%2);
            num /= 2;
        }
        return ReverseString.stack(sb.toString());
    }
}
