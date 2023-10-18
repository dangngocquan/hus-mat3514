package hw5_21000699_dangngocquan.exercise003;

import java.util.LinkedList;
import java.util.List;

public abstract class Solution {
    /*
    *
    * Return an expression tree if input tokens is valid.
    * Otherwise, return string message.
    *
    */
    public abstract Object buildExpressionTree(String[] tokens);

    protected String[] reformatInfixTokens(String[] tokens) {
        List<String> listToken = new LinkedList<>();
        String prevToken = "(";
        int bracketStatus = 0;
        for (String token : tokens) {
            // Update bracket status
            if (isOpenBracket(token)) bracketStatus++;
            if (isCloseBracket(token)) bracketStatus--;
            // Append token
            if (isOperation(token) && operationPriority(token) == 1) {
                if (isOpenBracket(prevToken)) {
                    listToken.add("0");
                }
            }
            if (isOpenBracket(token)) {
                if (isCloseBracket(prevToken) || isNumber(prevToken))
                    listToken.add("*");
            }
            // Append current token
            listToken.add(token);
            // Update previous token
            prevToken = token;
        }
        // While number of open brackets is more than number of close brackets,
        // add some close brackets to last of list token
        while (bracketStatus-- > 0) listToken.add(")");
        return listToken.toArray(new String[0]);
    }

    public int operationPriority(String operationToken) {
        if (operationToken == null) return 0;
        if (operationToken.equals("+") || operationToken.equals("-")) return 1;
        if (operationToken.equals("*") || operationToken.equals("/")) return 2;
        return 0;
    }

    protected boolean isNumber(String token) {
        if (token == null) return false;
        return token.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }

    protected boolean isOperation(String token) {
        if (token == null) return false;
        return token.matches("[+\\-*/]");
    }

    protected boolean isOpenBracket(String token) {
        return token.equals("(");
    }

    protected boolean isCloseBracket(String token) {
        return token.equals(")");
    }
}
