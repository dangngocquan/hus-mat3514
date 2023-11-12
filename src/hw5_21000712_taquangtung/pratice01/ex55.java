package hw5_21000712_taquangtung.pratice01;

import java.util.Scanner;

/* Codelearn 55 - Dãy Fibonacci
Hai số đầu tiên là số 1.
Các số tiếp theo lần lượt được tạo thành từ tổng của 2 số trước nó.
Dãy fibonacci: 1, 1, 2, 3, 5, 8, 13, 21, ...
Nhập vào một số nguyên dương n, hãy đưa ra số fibonacci thứ n. Hãy thực hiện điều đó bằng giải thuật đệ quy.
 */

public class ex55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacii(n));
    }

    static long fibonacii(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacii(n - 1) + fibonacii(n - 2);
    }
}
