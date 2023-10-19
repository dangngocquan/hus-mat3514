package hw5_21000699_dangngocquan.exercise003;

import hw5_21000699_dangngocquan.base.LinkedBinaryTree;
import hw5_21000699_dangngocquan.exercise002.a.ExpressionTree;

/*
*
* This solution will directly build expression tree from tokens input.
*
*/
public class ExpressionTreeBuilder1 extends ExpressionTreeBuilder {
    @Override
    public Object buildExpressionTree(String[] tokens) {
        tokens = reformatInfixTokens(tokens);
        int bracketStatus = 0; // Increase by 1 when token is "(", Decrease by 1 when token is ")"
        LinkedBinaryTree.Node<String> node
                = new LinkedBinaryTree.Node<>(
                null, null, null, null);
        for (String token: tokens) {
            if (isNumber(token)) {
                assert node != null;
                if (node.left == null) {
                    node.left = new LinkedBinaryTree.Node<>(
                            token, node, null, null);
                } else {
                    if (node.element == null)
                        return "Array tokens input is invalid. "
                                + "Token " + node.left + " and " + "token " + token
                                + " are missing operation.";
                    if (node.right != null)
                        return "Array tokens input is invalid. "
                                + "Expression "
                                + String.format("(%s %s %s)", node.left, node.element, node.right)
                                + " and token " + token
                                + " are missing operation.";
                    node.right = new LinkedBinaryTree.Node<>(
                            token, node, null, null);
                }
            } else if (isOperation(token)) {
                assert node != null;
                if (node.left == null) {
                    return "Array tokens input is invalid. "
                            + "Missing left expression of token " + token + ".";
                }
                if (node.element == null) {
                    node.element = token;
                } else {
                    if (node.right == null) {
                        return "Array tokens input is invalid. "
                                + "Missing expression between token "
                                + node.element + " and token " + token + ".";
                    } else {
                        while (operationPriority(token) <= operationPriority(node.element)
                                && node.parent != null
                                && node.parent.element != null) {
                            node = node.parent;
                        }
                        if (operationPriority(token) > operationPriority(node.element)) node = node.right;
                        LinkedBinaryTree.Node<String> node0 =
                                new LinkedBinaryTree.Node<>(
                                        node.element, node, node.left, node.right);
                        if (node0.left != null) node0.left.parent = node0;
                        if (node0.right != null) node0.right.parent = node0;
                        node.left = node0;
                        node.element = token;
                        node.right = null;
                    }
                }
            } else if (isOpenBracket(token)) {
                bracketStatus++;
                assert node != null;
                if (node.left == null) {
                    node.left = new LinkedBinaryTree.Node<>(
                            null, node, null, null
                    );
                    node = node.left;
                } else if (node.right == null) {
                    node.right = new LinkedBinaryTree.Node<>(
                            null, node, null, null
                    );
                    node = node.right;
                }
            } else if (isCloseBracket(token)) {
                if (bracketStatus == 0)
                    return "Array tokens input is invalid. "
                            + "Unpaired token: ')'.";
                bracketStatus--;
                assert node != null;
                if (node.element == null) {
                    if (node.left == null && node.right == null)
                        return "Array tokens input is invalid. "
                                + "Blank brackets: \"()\".";
                    assert node.left != null;
                    node.element = node.left.element;
                    node.left = null;
                    node.right = null;
                }
                node = node.parent;
            } else {
                return "Array tokens input is invalid. ";
            }
        }

        while (true) {
            assert node != null;
            if (node.parent == null) break;
            node = node.parent;
        }
        while (true) {
            if (node.element != null) break;
            if (node.left == null) break;
            node = node.left;
        }
        ExpressionTree expressionTree = new ExpressionTree();
        expressionTree.addRoot(node);
        return expressionTree;
    }
}
