package hw4_21000699_dangngocquan.exercise003;

import java.util.List;

public class Test {
    public void run() {
        showTestValidBrackets();
        showTestValidExpressions();
        showTestCalculateExpressions();
    }

    public String dashes(int length) {
        return "-".repeat(Math.max(0, length));
    }

    public void showTestValidBrackets() {
        System.out.printf("\n%-20s \n", "TEST VALID BRACKETS");
        System.out.printf(
                "\t%-40s %-15s\n",
                "Expression",
                "Result"
        );
        System.out.println("\t" + dashes(66));

        testValidBrackets("(a-b)*(c+d)");
        testValidBrackets("(10+8)/((5-2)*17)");
        testValidBrackets("(a+b)*c-d)");
        testValidBrackets("(10-8/((2+5)*17)");
        testValidBrackets(")u-v)*(m+n)");
        testValidBrackets("(1+((2+3)*(8*5)))");
        testValidBrackets("(5-(8-4)*(2+3))+(8/4)");

    }

    public void testValidBrackets(String expression) {
        Expression expression0 = new Expression(expression);
        System.out.printf(
                "\t%-40s %-15s\n",
                expression,
                expression0.isValidBrackets()? "Valid" : "Invalid"
        );
    }

    public void showTestValidExpressions() {
        System.out.printf("\n%-20s \n", "TEST VALID EXPRESSIONS");
        System.out.printf(
                "\t%-40s %-15s\n",
                "Expression",
                "Result"
        );
        System.out.println("\t" + dashes(66));

        testValidExpression("(1+((2+3)*(8*5)))");
        testValidExpression("(5-(8-4)*(2+3))+(8/4)");
        testValidExpression("-1+2*3+4/4");
        testValidExpression("1+2+3(2+1)");
        testValidExpression("1+2++3");
        testValidExpression("1+(2+3+)");
        testValidExpression("1+()+2");
        testValidExpression("1+(*2+3)");
        testValidExpression("1*(2+3)(4+5)");
        testValidExpression("1+(2+3)4");
    }

    public void testValidExpression(String expression) {
        Expression expression0 = new Expression(expression);
        System.out.printf(
                "\t%-40s %-15s\n",
                expression,
                expression0.isValidExpression()? "Valid" : "Invalid"
        );
    }

    public void showTestCalculateExpressions() {
        System.out.printf("\n%-40s \n", "TEST CALCULATE EXPRESSIONS");
        System.out.printf(
                "\t%-40s %-45s %-10s\n",
                "Expression",
                "Infix and Postfix",
                "Result"
        );

        System.out.println("\t" + dashes(112));

        testCalculateExpression("(1+((2+3)*(8*5)))");
        testCalculateExpression("(5-(8-4)*(2+3))+(8/4)");
        testCalculateExpression("1+2*3-4");
        testCalculateExpression("1+2*3*(-2+5)");
        testCalculateExpression("1+2/(1-1)");
        testCalculateExpression("-3*2");
        testCalculateExpression("-12+3*(-2)");
        testCalculateExpression("1+()+2");

    }

    public void testCalculateExpression(String expression) {
        Expression expression0 = new Expression(expression);
        List<String> infix = expression0.expressionToInfix();
        List<String> postfix = expression0.infixToPostfix(infix);
        String infixString = join(infix, " ");
        if (infixString.isBlank()) infixString = "Invalid";
        String postfixString = join(postfix, " ");
        if (postfixString.isBlank()) postfixString = "Invalid";
        String result = expression0.evaluate(postfix);
        System.out.printf(
                "\t%-40s %-45s %-10s\n",
                expression,
                infixString,
                result
        );
        System.out.printf(
                "\t%-40s %-45s %-10s\n",
                ".",
                postfixString,
                "."
        );
    }

    public String join(List<String> list, String separate) {
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word).append(separate);
        }
        if (sb.length() > 0) sb.delete(sb.length()-separate.length(), sb.length());
        return sb.toString();
    }
}
