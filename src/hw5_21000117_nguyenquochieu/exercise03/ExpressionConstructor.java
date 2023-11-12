package hw5_21000117_nguyenquochieu.exercise03;

import java.util.Stack;

public class ExpressionConstructor {
    private String expression;
    private Stack<Node<Character>> expressionStack = new Stack<>();

    public ExpressionConstructor(String expression) {
        this.expression = expression;
    }

    class Node<E> {
        private E element;

        private Node left;
        private Node right;

        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public E getElement() {
            return element;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public void construct() {
        String convertedExpression = convert2Postfix(expression);

        char[] tokens = convertedExpression.toCharArray();

        Stack<Integer> values = new Stack<Integer>();

        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            Node<Character> currentNode = new Node<>(tokens[i]);

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                expressionStack.push(currentNode);
            } else {
                Node<Character> rightTerm = expressionStack.pop();
                Node<Character> leftTerm = expressionStack.pop();
                currentNode.right = rightTerm;
                currentNode.left = leftTerm;
                expressionStack.push(currentNode);
            }
        }
        Node<Character> root = expressionStack.pop();
        printNode(root, 10);

    }

    private void printNode(Node root, int space) {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += 10;

        // Process right child first
        printNode(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.element + "\n");

        // Process left child
        printNode(root.left, space);
    }

    private String convert2Postfix(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                builder.append(tokens[i]);
            } else if (tokens[i] == '(') {
                stack.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (stack.peek() != '(') {
                    builder.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && isOperator(stack.peek()) && hasPrecedence(stack.peek(), tokens[i])) {
                    builder.append(stack.pop());
                }
                stack.push(tokens[i]);
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    private boolean hasPrecedence(
            char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    private boolean isOperator(char term) {
        return term == '+' || term == '-' || term == '*' || term == '/';
    }

}
