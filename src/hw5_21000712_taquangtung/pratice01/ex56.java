package hw5_21000712_taquangtung.pratice01;

import java.util.Scanner;

/* Codelearn 56 - Trò chơi đoán số
Trong một trong trò chơi đoán số, hệ thống sẽ tạo ngẫu nhiên một số nguyên từ 1 đến n.
Việc của bạn cần đoán ra số đó là số nào:
+ Nếu bạn đoán trúng thì bạn chiến thắng, trò chơi kết thúc.
+ Nếu bạn đoán lớn hơn thì hệ thống sẽ thông báo là: "high" và yêu cầu bạn đoán số khác.
+ Nếu bạn đoán bé hơn thì hệ thống sẽ thông báo là: "low" và yêu cầu bạn đoán số khác.
Cho số nguyên dương n (1 ≤ n ≤ 1015) hãy tìm và đưa ra số lần đoán ít nhất để chắc chắn sẽ đoán trúng số của hệ thống.
Biết rằng ta sẽ chọn cách đoán thông minh nhất có thể.
 */

public class ex56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        // Cách đoán thông minh nhất
        System.out.println(recursion(n));
    }

    static int recursion(long n) {
        if (n == 1) {
            return 1;
        }
        return 1 + recursion(n - (n+1)/2);
    }
}
