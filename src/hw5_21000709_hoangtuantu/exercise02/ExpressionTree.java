package hw5_21000709_hoangtuantu.exercise02;

import hw5_21000709_hoangtuantu.exercise01.LinkedBinaryTree;
import hw5_21000709_hoangtuantu.exercise01.Node;

public class ExpressionTree<E> extends LinkedBinaryTree {
    private Node<E> root;
    public ExpressionTree(Node<E> root) {
        this.root = root;
    }

    public void preorderPrint (Node<E> p) {
        printPreOrder(p);
        System.out.println();
    }
    public void postorderPrint ( Node <E > p ){
        printPostOrder(p);
        System.out.println();
    }

    public void inorderPrint ( Node <E > p ) {
        printInOrder(p);
        System.out.println();
    }


    public void preorderPrint () {
        printPreOrder(root);
        System.out.println();
    }
    public void postorderPrint ( ){
        printPostOrder(root);
        System.out.println();
    }

    public void inorderPrint () {
        printInOrder(root);
        System.out.println();
    }
    public double evaluateExpressionTree(Node<E> root){
        if (root == null){
            return 0;
        }else if (root.left == null && root.right == null){
            return Double.parseDouble(root.element.toString());
        }

        double leftValue = evaluateExpressionTree(root.left);
        double rightValue = evaluateExpressionTree(root.right);
        if (root.element.equals("+")){
            return leftValue + rightValue;
        }else if(root.element.equals("-")){
            return leftValue - rightValue;
        }else if(root.element.equals("/")){
            return leftValue / rightValue;
        }
        return leftValue * rightValue;
    }

}
