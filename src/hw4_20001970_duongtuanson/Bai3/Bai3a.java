package hw4_20001970_duongtuanson.Bai3;
import java.util.Stack;
public class Bai3a {
//    Sử dụng stack viết chương trình xét tính hợp lệ về dấu ngoặc của biểu thức:
//        Ví dụ biểu thức hợp lệ về dấu ngoặc
//        (a − b) ∗ (c + d)
//        (10 + 8)/((5 − 2) ∗ 17)
    public Stack<String> stack = new Stack();

    public boolean checkEquation(String equation) {
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '(') {
                stack.push("(");
            } else if (equation.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Bai3a bai4 = new Bai3a();
        String equation = "(a − b) ∗ (c + d)";
        System.out.println("Kết quả: " + bai4.checkEquation(equation));
    }

}