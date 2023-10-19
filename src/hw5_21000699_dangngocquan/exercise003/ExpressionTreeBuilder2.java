package hw5_21000699_dangngocquan.exercise003;

import hw5_21000699_dangngocquan.base.LinkedBinaryTree;
import hw5_21000699_dangngocquan.exercise002.a.ExpressionTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
*
* This solution using stack to convert input tokens from infix to postfix.
* Then, use postfix tokens to create expression tree.
*
* */
public class ExpressionTreeBuilder2 extends ExpressionTreeBuilder {
    @Override
    public Object buildExpressionTree(String[] tokens) {
        tokens = reformatInfixTokens(tokens);
        Object postfixResult = postfix(tokens);
        if (postfixResult instanceof String) return postfixResult;
        List<String> postfixTokens = (List<String>) postfixResult;
        Stack<LinkedBinaryTree.Node<String>> stack = new Stack<>();
        for (String token : postfixTokens) {
            if (isNumber(token)) {
                stack.push(new LinkedBinaryTree.Node<>(token, null, null, null));
            } else if (isOperation(token)) {
                if (stack.size() == 0)
                    return "Array tokens input is invalid. "
                        + "Missing left expression of token " + token + ".";
                if (stack.size() == 1)
                    return "Array tokens input is invalid. "
                            + "Missing right expression of token " + token + ".";
                LinkedBinaryTree.Node<String> rightChild = stack.pop();
                LinkedBinaryTree.Node<String> leftChild = stack.pop();
                LinkedBinaryTree.Node<String> node
                        = new LinkedBinaryTree.Node<>(token, null, leftChild, rightChild);
                leftChild.parent = node;
                rightChild.parent = node;
                stack.push(node);
            } else {
                return "Array tokens input is invalid. ";
            }
        }

        ExpressionTree expressionTree = new ExpressionTree();
        if (stack.size() != 1) return "Array tokens input is invalid. ";
        expressionTree.addRoot(stack.pop());
        return expressionTree;
    }

    private Object postfix(String[] infixTokens) {
        List<String> postfixTokens = new LinkedList<>();
        Stack<String> operationStack = new Stack<>();
        for (String token : infixTokens) {
            if (isNumber(token)) {
                postfixTokens.add(token);
            } else if (isOpenBracket(token)) {
                operationStack.push(token);
            } else if (isCloseBracket(token)) {
                while (!operationStack.isEmpty() && !isOpenBracket(operationStack.peek()))
                    postfixTokens.add(operationStack.pop());
                if (operationStack.isEmpty()) return "Array tokens input is invalid. Unpaired token: ')'.";
                operationStack.pop();
            } else if (isOperation(token)) {
                while (!operationStack.isEmpty()
                        && operationPriority(token) <= operationPriority(operationStack.peek())) {
                    postfixTokens.add(operationStack.pop());
                }
                operationStack.push(token);
            } else {
                return "Array tokens input is invalid. ";
            }
        }
        while (!operationStack.isEmpty()) postfixTokens.add(operationStack.pop());
        return postfixTokens;
    }
}
