package hw5_21000712_taquangtung.ex03;


import java.util.Stack;

public class ArithmeticExpression {
    public static void main(String[] args) {
        String [] tokens = {"(","6", "/", "3","+","2",")", "*", "(", "7", "-", "4",")"};

        // Mảng gồm post-Order Array
        String[] arrayTokens = postOrderArray(tokens);
        System.out.println("Post-Order Array:");
        for (String element : arrayTokens) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Build Tree:");
        TreeNode expressionTree = buildExpressionTree(arrayTokens);

        // In cây dưới dạng đồ thị
        displayExpressionTree(expressionTree, "", true);

    }


    // Hàm tính kích cỡ mảng
    public static int sizePostOrderArray(String[] tokens) {
        int size = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("(") && !tokens[i].equals(")")) {
                size++;
            }
        }
        return size;
    }

    // Mảng postOrder - Chuyển từ trung tố sang hậu tố
    public static String[] postOrderArray(String[] tokens) {
        String[] postOrderTokens = new String[sizePostOrderArray(tokens)];
        Stack<String> bracket = new Stack<>();      // Cho dấu ngoặc vào đây

        int index = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("(") || tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/")) {
                if (!bracket.isEmpty()) {
                    String ele = bracket.peek();
                    while (!ele.equals("(") && !tokens[i].equals("(") && order(ele) >= order(tokens[i])) {
                        postOrderTokens[index] = bracket.pop();
                        ele = bracket.peek();
                        index++;
                    }
                }
                bracket.push(tokens[i]);
            } else if (tokens[i].equals(")")) {
                String ele = bracket.peek();
                while (!ele.equals("(")) {
                    postOrderTokens[index] = bracket.pop();
                    ele = bracket.peek();
                    index++;
                }
                bracket.pop();
            } else {
                postOrderTokens[index] = tokens[i];
                index++;
            }
        }
        while (!bracket.isEmpty()) {
            postOrderTokens[index] = bracket.pop();
            index++;
        }
        return postOrderTokens;
    }

    // Kiểm tra độ ưu tiên toán tử
    static int order(String operator) {
        return (operator.equals("+") || operator.equals("-")) ? 1 : 2;
    }


    // In ra hình cây
    public static TreeNode buildExpressionTree(String[] postOrderTokens) {
        Stack<TreeNode> stack = new Stack<>();

        for (String token : postOrderTokens) {
            if (isOperator(token)) {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                TreeNode operatorNode = new TreeNode(token);
                operatorNode.left = left;
                operatorNode.right = right;
                stack.push(operatorNode);
            } else {
                TreeNode operandNode = new TreeNode(token);
                stack.push(operandNode);
            }
        }

        return stack.pop();
    }

    // Kiểm tra toán tử
    public static boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    // Sử dụng đệ quy để vẽ hình cây
    public static void displayExpressionTree(TreeNode root, String prefix, boolean isLeft) {
        if (root != null) {
            displayExpressionTree(root.left, prefix + "    ", true);
            System.out.println(prefix + "" + root.value);
            displayExpressionTree(root.right, prefix + "    ", false);
        }
    }

}
