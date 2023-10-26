package hw4_21000506_nguyenthithanhhuong.practice03;

import hw4_21000506_nguyenthithanhhuong.ex02.ArrayStack;
import hw4_21000506_nguyenthithanhhuong.ex02.LinkedListStack;
import hw4_21000506_nguyenthithanhhuong.ex02.StackInterface;

public class TestDeleteMid {
    public static void main(String[] args) {
        // Test 01
        StackInterface<Integer> stack1 = new ArrayStack<>();
        stack1.push(50);
        stack1.push(40);
        stack1.push(30);
        stack1.push(20);
        stack1.push(10);

        System.out.println("Result test 01: ");
        System.out.println("Stack input: " + stack1.toString());
        DeleteMid.deleteMid(stack1, stack1.size());
        System.out.println("Stack after delete mid element: " + stack1.toString());

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        // Test 02
        StackInterface<Integer> stack2 = new LinkedListStack<>();
        stack2.push(40);
        stack2.push(30);
        stack2.push(20);
        stack2.push(10);

        System.out.println("Result test 02: ");
        System.out.println("Stack input: " + stack2.toString());
        DeleteMid.deleteMid(stack2, stack2.size());
        System.out.println("Stack after delete mid element: " + stack2.toString());
    }

    //    Result test 01:
    //    Stack input: [10, 20, 30, 40, 50]
    //    Stack after delete mid element: [10, 20, 40, 50]
    //    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //    Result test 02:
    //    Stack input: [10, 20, 30, 40]
    //    Stack after delete mid element: [10, 30, 40]
}
