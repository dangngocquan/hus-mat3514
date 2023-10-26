package hw4_20001970_duongtuanson.Bai1;
import java.util.Scanner;
import java.util.Stack;
public class bai1 {
    // Giải thích code
    // 1. Tạo một stack rỗng
    // 2. Duyệt từng ký tự trong chuỗi
    // 3. Nếu ký tự là một trong các ký tự mở ngoặc thì đẩy vào stack
    // 4. Nếu ký tự là một trong các ký tự đóng ngoặc thì lấy ký tự ở đỉnh stack ra
    // 5. Nếu ký tự ở đỉnh stack không phải là ký tự mở ngoặc tương ứng thì trả về false
    // 6. Nếu ký tự ở đỉnh stack là ký tự mở ngoặc tương ứng thì tiếp tục duyệt
    // 7. Nếu stack rỗng thì trả về true
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        System.out.println("Kết quả: " + check(s));
    }
public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c;
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    c = stack.pop();
                    if (c != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    c = stack.pop();
                    if (c != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    c = stack.pop();
                    if (c != '{') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

}
