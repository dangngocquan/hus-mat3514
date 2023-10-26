package hw4_21000506_nguyenthithanhhuong.ex03;

public class TestBalancedBracket {
    public static void main(String[] args) {
        System.out.println(Expression.isBalancedBracket("(a − b) ∗ (c + d)")); //true
        System.out.println(Expression.isBalancedBracket("(10 + 8)/((5 − 2) ∗ 17)")); //true
        System.out.println(Expression.isBalancedBracket("(a + b) ∗ c − d)")); //false
        System.out.println(Expression.isBalancedBracket("(10 − 8/((2 + 5) ∗ 17)")); //false
        System.out.println(Expression.isBalancedBracket(")u − v) ∗ (m + n)")); //false
        System.out.println(Expression.isBalancedBracket("(a − b)) ∗ (c + d)")); //false
        System.out.println(Expression.isBalancedBracket("[(a − b) ∗ (c + d)]")); //true
        System.out.println(Expression.isBalancedBracket("(a − b{ ∗ )c + d)")); //false
        System.out.println(Expression.isBalancedBracket("(a − b) ∗ ]c + d{")); //false
    }
}
