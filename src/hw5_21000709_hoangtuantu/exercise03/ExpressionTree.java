package hw5_21000709_hoangtuantu.exercise03;

import hw5_21000709_hoangtuantu.exercise01.LinkedBinaryTree;
import hw5_21000709_hoangtuantu.exercise01.Node;

import java.util.Stack;

public class ExpressionTree extends LinkedBinaryTree {
    Node<String> root;
    public Node<String> buildExpressionTree(String[] tokens) {
        Stack<Node<String>> nodeStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (isOperand(token)) {
                nodeStack.push(new Node<>(token));
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    buildSubTree(nodeStack, operatorStack);
                }
                operatorStack.pop(); // Remove the "("
            } else {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    buildSubTree(nodeStack, operatorStack);
                }
                operatorStack.push(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            buildSubTree(nodeStack, operatorStack);
        }

        return nodeStack.pop();
    }

    public ExpressionTree(String[] tokens){
        this.root = buildExpressionTree(tokens);
    }

    private void buildSubTree(Stack<Node<String>> nodeStack, Stack<String> operatorStack) {
        String operator = operatorStack.pop();
        Node<String> rightOperand = nodeStack.pop();
        Node<String> leftOperand = nodeStack.pop();
        Node<String> operatorNode = new Node<>(operator);
        operatorNode.left = leftOperand;
        operatorNode.right = rightOperand;
        nodeStack.push(operatorNode);
    }

    private boolean isOperand(String token) {
        return token.matches("\\d+"); // Check if the token is a digit (operand)
    }

    private int precedence(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        return 0;
    }

    public Node<String> root() {
        return root;
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

    public double evaluate(){
       return new hw5_21000709_hoangtuantu.exercise02.ExpressionTree<String>(root).evaluateExpressionTree(root);
    }
}