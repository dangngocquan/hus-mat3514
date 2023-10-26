package hw4_20001970_duongtuanson.Bai3;
import java.util.Stack;

public class Bai3b {
    //    Tính giá trị biểu thức nếu hợp lệ về dấu ngoặc
    //    Ví dụ biểu thức hợp lệ về dấu ngoặc
//    Ví dụ 1:
//            – Input: (1 + ((2 + 3) ∗ (8 ∗ 5)))
//            – Output: 201
   public Stack<String> stack = new Stack();

   public static int evaluateExpression(String expression) {
       Stack<Integer> operandStack = new Stack<>();
       Stack<Character> operatorStack = new Stack<>();
       expression = insertBlanks(expression);
       String[] tokens = expression.split(" ");
       for (String token : tokens) {
           if (token.length() == 0) {
               continue;
           } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
               while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                   processAnOperator(operandStack, operatorStack);
               }
               operatorStack.push(token.charAt(0));
           } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
               while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                   processAnOperator(operandStack, operatorStack);
               }
               operatorStack.push(token.charAt(0));
           } else if (token.trim().charAt(0) == '(') {
               operatorStack.push('(');
           } else if (token.trim().charAt(0) == ')') {
               while (operatorStack.peek() != '(') {
                   processAnOperator(operandStack, operatorStack);
               }
               operatorStack.pop();
              } else {
                   operandStack.push(Integer.parseInt(token));
           }
       }
       while (!operatorStack.isEmpty()) {
           processAnOperator(operandStack, operatorStack);
       }
       return operandStack.pop();
   }

    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
         char op = operatorStack.pop();
         int op1 = operandStack.pop();
         int op2 = operandStack.pop();
         if (op == '+') {
              operandStack.push(op2 + op1);
         } else if (op == '-') {
              operandStack.push(op2 - op1);
         } else if (op == '*') {
              operandStack.push(op2 * op1);
         } else if (op == '/') {
              operandStack.push(op2 / op1);
         }
    }
    public static String insertBlanks(String s) {
         String result = "";
         for (int i = 0; i < s.length(); i++) {
              if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                   result += " " + s.charAt(i) + " ";
              } else {
                   result += s.charAt(i);
              }
         }
         return result;
    }
    public static boolean checkEquation(String equation) {
         Stack<String> stack = new Stack();
         for (int i = 0; i < equation.length(); i++) {
              if (equation.charAt(i) == '(') {
                   stack.push("(");
              } else if (equation.charAt(i) == ')') {
                   if (stack.isEmpty()) {
                        return false;
                   } else {
                        stack.pop();
                   }
              }
         }
         return stack.isEmpty();
    }

    public static void main(String[] args) {
         String expression = "2/0";
         int result = evaluateExpression(expression);
         System.out.println("Input: " + expression);
         System.out.println("Output: " + result);
    }
}
