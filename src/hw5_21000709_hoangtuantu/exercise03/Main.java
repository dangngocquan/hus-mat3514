package hw5_21000709_hoangtuantu.exercise03;

public class Main {
    public static void main(String[] args) {
        String[] tokens = {"(", "6", "/", "3", "+", "2", ")", "*", "(", "7", "-", "4", ")"};
        ExpressionTree expressionTree = new ExpressionTree(tokens);
        expressionTree.inorderPrint();
    }
}
