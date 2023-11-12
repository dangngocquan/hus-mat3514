package hw5_21000712_taquangtung.pratice01;

import java.util.Scanner;

/* Codelearn 53 - Tính lũy thừa đệ quy
Nhập và hai tự nhiên a và b. Hãy tính giá trị của a^b?
 */

public class ex53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Cơ số a
        int a = sc.nextInt();

        // Số mũ b
        int b = sc.nextInt();

        // Kết quả a^b
        System.out.println(pow(a, b));
    }

    static long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * pow(a, b-1);
    }
}
