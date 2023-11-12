package hw5_21000712_taquangtung.pratice01;

/* Codelearn 57 - Đếm số biến đổi
Với số tự nhiên n nếu:
n là số chẵn thì biến đổi n thành n/2.
n là số lẽ thì biến đổi n thành 3*n+1.
Hiện tại Hải đang có hai số tự nhiên n và k
Muốn biết số lượng số mà khi số đó biến đổi k lần liên tiếp thì biến đổi thành số n.
 */

import java.util.Scanner;

public class ex57 {
    public static int count = 0;        // Số phép biến đổi ít nhất
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Thực hiện phép biến đổi
        System.out.println(recursion(n, k));
    }

    static int recursion(int n, int k) {
        if (k == 0) {
            count++;
        } else {
            recursion(2 * n, k - 1);
            if ((n - 1) % 3 == 0 && ((n - 1) / 3) % 2 == 1) {
                recursion((n-1)/3, k-1);
            }
        }
        return count;
    }
}
