package hw4_21000506_nguyenthithanhhuong.ex02;

public class TestArrayStack {
    public static void main(String[] args) {
        StackInterface stack = new ArrayStack();

        stack.push(18);
        stack.push(12);
        stack.push(10);

        System.out.println("Stack: " + stack.toString());
        System.out.println("Test size: " + stack.size());
        System.out.println("Test top: " + stack.top());
        System.out.println("Test pop: " + stack.pop());
        System.out.println("Stack after use pop(): ");
        System.out.println("Stack: " + stack.toString());
        System.out.println("Stack size: " + stack.size());
    }

    //    Result:
    //    Stack: [10, 12, 18]
    //    Test size: 3
    //    Test top: 10
    //    Test pop: 10
    //    Stack after use pop():
    //    Stack: [12, 18]
    //    Stack size: 2
}
