package hw5_21000712_taquangtung.pratice01;

import java.util.Scanner;

/* Codelearn 54 - Tìm ước chung lớn nhất
Nhập vào hai số nguyên a và b. Hãy tìm ước chung lớn nhất của chúng.
(Ước chung lớn nhất của hai số nguyên là một số lớn nhất mà cả hai số đó đều chia hết).
 */

public class ex54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Tính ước chung lớn nhất
        System.out.println(ucln(a, b));
    }

    static int ucln(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (a % b == 0) {
            return b;
        }
        return ucln(b, a % b);
    }
}
