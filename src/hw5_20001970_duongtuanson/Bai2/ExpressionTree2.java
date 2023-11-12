package hw5_20001970_duongtuanson.Bai2;

public class ExpressionTree2 {

        public static class TreeNode {
            char value;
            TreeNode left;
            TreeNode right;

            TreeNode(char value) {
                this.value = value;
            }
        }
        public static boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }

        public static int evaluateExpressionTree(TreeNode root) {
            if (root == null) {
                throw new IllegalArgumentException("Invalid expression tree.");
            }
            if (root.left == null && root.right == null) {
                return Character.getNumericValue(root.value);
            } else {
                int leftValue = evaluateExpressionTree(root.left);
                int rightValue = evaluateExpressionTree(root.right);
                char operator = root.value;

                if (isOperator(operator)) {
                    switch (operator) {
                        case '+':
                            return leftValue + rightValue;
                        case '-':
                            return leftValue - rightValue;
                        case '*':
                            return leftValue * rightValue;
                        case '/':
                            if (rightValue == 0) {
                                throw new ArithmeticException("Division by zero");
                            }
                            return leftValue / rightValue;
                        default:
                            throw new IllegalArgumentException("Invalid operator.");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid operator.");
                }
            }
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode('*');
            root.left = new TreeNode('+');
            root.left.left = new TreeNode('/');
            root.left.left.left = new TreeNode('6');
            root.left.left.right = new TreeNode('3');
            root.left.right = new TreeNode('2');
            root.right = new TreeNode('-');
            root.right.left = new TreeNode('7');
            root.right.right = new TreeNode('4');

            int result = evaluateExpressionTree(root);
            System.out.println("The result of the expression tree is: " + result);
        }
}
