package hw4_21000506_nguyenthithanhhuong.ex03;

public class TestCalculateExpression {
    public static void main(String[] args) {
        String expression1 = "(1+((2+3)*(8*5)))";
        String expression2 = "(5-(8-4)*(2+3))+(8/4)";
        String expression3 = "18+12-(2*4)/4";
        String expression4 = "15+9*(4+10)*2";

        int res1 = Expression.calculateExpression("(1+((2+3)*(8*5)))");
        int res2 = Expression.calculateExpression("(5-(8-4)*(2+3))+(8/4)");
        int res3 = Expression.calculateExpression("18+12-(2*4)/4");
        int res4 = Expression.calculateExpression("1/0");

        System.out.printf("Result of expression \"%s\" is: %d\n", expression1, res1);
        System.out.printf("Result of expression \"%s\" is: %d\n", expression2, res2);
        System.out.printf("Result of expression \"%s\" is: %d\n", expression3, res3);
        System.out.printf("Result of expression \"%s\" is: %d", expression4, res4);
    }

    //    Result test:
    //    Result of expression "(1+((2+3)*(8*5)))" is: 201
    //    Result of expression "(5-(8-4)*(2+3))+(8/4)" is: -13
    //    Result of expression "18+12-(2*4)/4" is: 28
    //    Result of expression "15+9*(4+10)*2" is: 267
}
