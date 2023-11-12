package hw5_21000712_taquangtung.ex02;

import hw5_21000712_taquangtung.ex01.LinkedBinaryTree;

import java.util.ArrayList;

public class ExpressionTree<E> extends LinkedBinaryTree {
    public void preorderPrint(Node<E> p) {
        // pre-order traversal of tree with root p (Root, Left, Right)
        if (p != null) {
            System.out.print(p.getElement() + " ");         // Print the root element
            preorderPrint(p.getLeft());                     // Recursively traverse the left subtree
            preorderPrint(p.getRight());                    // Recursively traverse the right subtree
        }
    }

    public void postorderPrint(Node<E> p) {
        // post-order traversal of tree with root p (Left, Right, Root)
        if (p != null) {
            postorderPrint(p.getLeft());                    // Recursively traverse the left subtree
            postorderPrint(p.getRight());                   // Recursively traverse the right subtree
            System.out.print(p.getElement() + " ");         // Print the root element
        }
    }

    public void inorderPrint(Node<E> p) {
        // in-order traversal of tree with root p (Left, Root, Right)
        if (p != null) {
            inorderPrint(p.getLeft());                  // Recursively traverse the left subtree
            System.out.print(p.getElement() + " ");     // Print the root element
            inorderPrint(p.getRight());                 // Recursively traverse the right subtree
        }
    }

    public ArrayList<String> arrayArithmeticCalculate(Node<E> p) {
        ArrayList<String> arrayArithmetic = new ArrayList<String>();
        if (p != null) {
            arrayArithmetic.addAll(arrayArithmeticCalculate(p.getLeft()));              // Lấy danh sách từ cây con bên trái
            arrayArithmetic.addAll(arrayArithmeticCalculate(p.getRight()));             // Lấy danh sách từ cây con bên phải
            arrayArithmetic.add(String.valueOf(p.getElement()));                        // Thêm phần tử hiện tại vào danh sách
        }
        return arrayArithmetic;
    }
}
