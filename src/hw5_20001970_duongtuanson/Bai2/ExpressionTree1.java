package hw5_20001970_duongtuanson.Bai2;

public class ExpressionTree1 {
        public static class TreeNode {
            char value;
            TreeNode left;
            TreeNode right;

            TreeNode(char value) {
                this.value = value;
            }
        }
        public static void inorderTraversal(TreeNode node) {
            if (node != null) {
                inorderTraversal(node.left);
                System.out.print(node.value + " ");
                inorderTraversal(node.right);
            }
        }

        public static void postorderTraversal(TreeNode node) {
            if (node != null) {
                postorderTraversal(node.left);
                postorderTraversal(node.right);
                System.out.print(node.value + " ");
            }
        }

        public static void preorderTraversal(TreeNode node) {
            if (node != null) {
                System.out.print(node.value + " ");
                preorderTraversal(node.left);
                preorderTraversal(node.right);
            }
        }

        public static String treeToInfixExpression(TreeNode node) {
            if (node == null) {
                return "";
            }
            if (node.left == null && node.right == null) {
                return String.valueOf(node.value);
            }
            String leftExpr = treeToInfixExpression(node.left);
            String rightExpr = treeToInfixExpression(node.right);
            return "(" + leftExpr + " " + node.value + " " + rightExpr + ")";
        }

        public static String treeToPostfixExpression(TreeNode node) {
            if (node == null) {
                return "";
            }
            if (node.left == null && node.right == null) {
                return String.valueOf(node.value);
            }
            String leftExpr = treeToPostfixExpression(node.left);
            String rightExpr = treeToPostfixExpression(node.right);
            return leftExpr + " " + rightExpr + " " + node.value;
        }

        public static String treeToPrefixExpression(TreeNode node) {
            if (node == null) {
                return "";
            }
            if (node.left == null && node.right == null) {
                return String.valueOf(node.value);
            }
            String leftExpr = treeToPrefixExpression(node.left);
            String rightExpr = treeToPrefixExpression(node.right);
            return node.value + " " + leftExpr + " " + rightExpr;
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

            System.out.println("Infix Expression:");
            inorderTraversal(root);
            System.out.println("\nPostfix Expression:");
            postorderTraversal(root);
            System.out.println("\nPrefix Expression:");
            preorderTraversal(root);

            String infixExpr = treeToInfixExpression(root);
            String postfixExpr = treeToPostfixExpression(root);
            String prefixExpr = treeToPrefixExpression(root);

            System.out.println("\nInfix Expression: " + infixExpr);
            System.out.println("Postfix Expression: " + postfixExpr);
            System.out.println("Prefix Expression: " + prefixExpr);
        }
    }
