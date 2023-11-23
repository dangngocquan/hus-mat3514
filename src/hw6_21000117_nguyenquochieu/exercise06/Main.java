package hw6_21000117_nguyenquochieu.exercise06;

import java.util.Scanner;

public class Main {
    /*
    Xây dựng chương trình mô phỏng sàn giao dịch chứng khoán.
    Mô tả:
    - Số lượng chứng khoán ở mỗi thời điểm là như nhau, bên mua và bên bán có
    số lượng bằng nhau.
    - Giá trị chứng khoán ở mỗi thời điểm là một giá trị ngẫu nhiên thuộc một
    khoảng cho trước.
    - Tại mỗi thời điểm, chương trình hỏi người dùng có muốn trade thử không.
        + Nếu người dùng nhấn "Y", chương trình tiến hành trade thử,
        + Ngược lại: chương trình kết thúc.
    - Quá trình trade thử diễn ra thành công khi có một chứng khoán bên mua
    có giá trị lớn hơn hoặc bằng giá trị của một chứng khoán bên bán. Nếu điều
    đó xảy ra, in ra mã của hai chứng khoán và thông báo, ngược lại chương trình
    quay lại bước trên.
    */
    public static void main(String[] args) {
        OrderController controller = new OrderController();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to trade now? Y/N");
            String choice = scanner.next().toLowerCase();
            if (choice.equals("y")) {
                int result = controller.trade();
                if (result >= 0) {
                    System.out.println("Trade successfully!");
                    break;
                }
            } else break;
        }
    }
}
