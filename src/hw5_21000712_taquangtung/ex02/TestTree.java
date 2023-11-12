package hw5_21000712_taquangtung.ex02;

import hw5_21000712_taquangtung.ex01.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class TestTree {
    public static void main(String[] args) {
        ExpressionTree<String>[] arrayTree = arrayTreeTest();
        for (int i = 0; i < 2; i++) {
            System.out.println("Test case " + (i + 1) + " là:");

            // In ra các dạng biểu diễn của cây nhị phân cho trước
            printExpressionTree(arrayTree[i]);

            // Tính toán giá trị
            ArrayList<String> arrayArithmetic = arrayTree[i].arrayArithmeticCalculate((LinkedBinaryTree.Node<String>) arrayTree[i].root());
            ArrayList<String> resultArray = calculateArithmeticExpression(arrayArithmetic);
            System.out.println("=> Value of the Expression is: " + resultArray.get(resultArray.size() - 1));
            System.out.println();
        }

    }

    // Hàm kiểm tra dữ liệu đầu vào
    public static ExpressionTree<String>[] arrayTreeTest() {
        // Khởi tạo mảng chứa cây
        ExpressionTree<String>[] testTree = new ExpressionTree[2];
        ExpressionTree<String> expressionTree1 = new ExpressionTree<>();
        ExpressionTree<String> expressionTree2 = new ExpressionTree<>();


        // Test Case 1: (6/3 + 2) * (7 - 4)
        ExpressionTree.Node<String> rootNode = expressionTree1.addRoot("*");
        ExpressionTree.Node<String> leftNode1 = expressionTree1.addLeft(rootNode, "+");
        ExpressionTree.Node<String> leftNode2 = expressionTree1.addLeft(leftNode1, "/");
        ExpressionTree.Node<String> leftLeftLeftChild = expressionTree1.addLeft(leftNode2, 6);
        ExpressionTree.Node<String> leftLeftRightChild = expressionTree1.addRight(leftNode2, 3);
        ExpressionTree.Node<String> leftRight = expressionTree1.addRight(leftNode1, 2);
        ExpressionTree.Node<String> rightNode1 = expressionTree1.addRight(rootNode, "-");
        ExpressionTree.Node<String> rightLeftChild = expressionTree1.addLeft(rightNode1, "7");
        ExpressionTree.Node<String> rightRightChild = expressionTree1.addRight(rightNode1, "4");
        testTree[0] = expressionTree1;

        // Test Case 2: (9-5)*((2+4):(6-3))
        ExpressionTree.Node<String> rootNew = expressionTree2.addRoot("*");
        ExpressionTree.Node<String> leftSubtree = expressionTree2.addLeft(rootNew, "-");
        expressionTree2.addLeft(leftSubtree, "9");
        expressionTree2.addRight(leftSubtree, "5");
        ExpressionTree.Node<String> rightSubtree = expressionTree2.addRight(rootNew, "/");
        ExpressionTree.Node<String> rightLeftSubtree = expressionTree2.addLeft(rightSubtree, "+");
        expressionTree2.addLeft(rightLeftSubtree, "2");
        expressionTree2.addRight(rightLeftSubtree, "4");
        ExpressionTree.Node<String> rightRightSubtree = expressionTree2.addRight(rightSubtree, "-");
        expressionTree2.addLeft(rightRightSubtree, "6");
        expressionTree2.addRight(rightRightSubtree, "3");
        testTree[1] = expressionTree2;

        return testTree;
    }

    // Duyệt cây theo từng cấu trúc
    public static void printExpressionTree(ExpressionTree<String> expressionTree) {

        // In ra biểu diễn trung tố của cây
        System.out.println("Infix Expression: ");
        expressionTree.inorderPrint((LinkedBinaryTree.Node<String>) expressionTree.root());
        System.out.println();

        // In ra biểu diễn hậu tố của cây
        System.out.println("Postfix Expression: ");
        expressionTree.postorderPrint((LinkedBinaryTree.Node<String>) expressionTree.root());
        System.out.println();

        // In ra biểu diễn tiền tố của cây
        System.out.println("Prefix Expression: ");
        expressionTree.preorderPrint((LinkedBinaryTree.Node<String>) expressionTree.root());
        System.out.println();
    }

    // Tính toán giá trị biểu thức cây bằng đệ quy
    public static ArrayList<String> calculateArithmeticExpression(ArrayList<String> arrayArithmetic) {
        ArrayList<String> arrayRecursive = new ArrayList<>();
        Stack<String> arrayNumber = new Stack<>();
        for (String element : arrayArithmetic) {
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                String valueExpress = String.valueOf(valueExpression(arrayNumber, element));
                arrayRecursive.add(valueExpress);
                arrayNumber.push(valueExpress);
            } else {
                // Nếu phần tử không phải là toán tử, đẩy nó vào arrayNumber
                arrayNumber.push(element);
            }

        }
        if (arrayRecursive.size() > 1) {
            return calculateArithmeticExpression(arrayRecursive);
        } else {
            return arrayArithmetic;
        }
    }

    public static int valueExpression(Stack<String> arrayNumber, String operation) {
        int number1 = Integer.valueOf(arrayNumber.pop());
        int number2 = Integer.valueOf(arrayNumber.pop());
        switch (operation) {
            case "+":
                return number2 + number1;
            case "-":
                return number2 - number1;
            case "*":
                return number2 * number1;
            case "/":
                if (number1 != 0) {
                    return number2 / number1;
                } else {
                    throw new ArithmeticException("Division by zero.");
            } default:
                throw new IllegalArgumentException("Invalid operator: " + operation);
        }
    }
}
