package hw1_21000699_dangngocquan.exercise005.p1dot27;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private Scanner scanner;
    private int statusBracket;
    private List<String> infix;

    public Calculator() {
        this.scanner = new Scanner(System.in);
        this.infix = new LinkedList<>();
        this.statusBracket = 0;
    }

    public void start() {
        String token;
        do {
            System.out.println();
            showMessage();
            token = scanner.next();
            if (!addInput(token)) break;
        } while (!token.isEmpty());
        scanner.close();
    }

    public void showMessage() {
        if (infix.size() == 0) {
            System.out.print("Enter a number: ");
        } else {
            String lastToken = infix.get(infix.size()-1);
            if (isNumber(lastToken)) {
                System.out.printf("Enter an operation + - * / %s\nExpression: %s",
                        statusBracket > 0? "or )" : "or =",
                        getCurrentInfixString());
            } else if (isOperation(lastToken)) {
                System.out.printf("Enter a number or (\nExpression: %s",
                        getCurrentInfixString());
            } else if (isOpenBracket(lastToken)) {
                System.out.printf("Enter a number\nExpression: %s",
                        getCurrentInfixString());
            } else if (isCloseBracket(lastToken)) {
                System.out.printf("Enter an operation + - * / %s\nExpression: %s",
                        statusBracket > 0? "or )" : "or =",
                        getCurrentInfixString());
            }
        }
    }

    public boolean addInput(String token) {
        if (infix.size() == 0) {
            String regex = "[0-9]{1,13}(\\.[0-9]{1,13})?";
            checkInput(token, regex);
        } else {
            String lastToken = infix.get(infix.size()-1);
            if (isNumber(lastToken)) {
                String regex = String.format("[+\\-*/%s]{1}", statusBracket > 0? ")" : "=");
                if (token.equals("=")) {
                    return evaluate() != null;
                } else {
                    checkInput(token,regex);
                    if (token.equals(")")) statusBracket--;
                }
            } else if (isOperation(lastToken)) {
                String regex = "[0-9]{1,13}(\\.[0-9]{1,13})?|\\(";
                checkInput(token,regex);
                if (token.equals("(")) statusBracket++;
            } else if (isOpenBracket(lastToken)) {
                String regex = "[0-9]{1,13}(\\.[0-9]{1,13})?";
                checkInput(token,regex);
            } else if (isCloseBracket(lastToken)) {
                String regex = String.format("[+\\-*/%s]{1}", statusBracket > 0? ")" : "=");
                if (token.equals("=")) {
                    return evaluate() != null;
                } else {
                    checkInput(token,regex);
                    if (token.equals(")")) statusBracket--;
                }
            }
        }
        return true;
    }

    public boolean checkInput(String token, String regex) {
        if (token.matches(regex)) {
            infix.add(token);
            return true;
        } else {
            System.out.println("Invalid input");
            return false;
        }
    }

    public boolean isNumber(String data) {
        return data.matches("[0-9]{1,13}(\\.[0-9]{1,13})?");
    }

    public boolean isOperation(String data) {
        return data.matches("[+\\-*/]{1}");
    }

    public boolean isOpenBracket(String data) {
        return data.equals("(");
    }

    public boolean isCloseBracket(String data) {
        return data.equals(")");
    }

    public String getCurrentInfixString() {
        StringBuilder sb = new StringBuilder("");
        for (String token : infix) sb.append(token);
        return sb.toString();
    }

    public int getPriorityOfOperation(String operation) {
        if (operation.matches("[*/]{1}")) {
            return 2;
        } else if (operation.matches("[+-]{1}")) {
            return 1;
        } else {
            return 0;
        }
    }

    public List<String> getPostfix() {
        List<String> postfix = new LinkedList<>();
        Stack<String> stackOperation = new Stack<>();
        for (String token : infix) {
            if (isNumber(token)) {
                postfix.add(token);
            } else if (isOpenBracket(token)) {
                stackOperation.add(token);
            } else if (isCloseBracket(token)) {
                while (!isOpenBracket(stackOperation.peek())) {
                    postfix.add(stackOperation.pop());
                }
                stackOperation.pop();
            } else {
                int currentPriorityOfOperation = getPriorityOfOperation(token);
                while (!stackOperation.isEmpty()
                        && getPriorityOfOperation(stackOperation.peek()) >= currentPriorityOfOperation) {
                    postfix.add(stackOperation.pop());
                }
                stackOperation.push(token);
            }
        }
        while (!stackOperation.isEmpty()) {
            postfix.add(stackOperation.pop());
        }
        return postfix;
    }

    public Double evaluate() {
        List<String> postfix = getPostfix();
        Stack<String> stack = new Stack<>();
        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(token);
            } else {
                double number2 = Double.parseDouble(stack.pop());
                double number1 = Double.parseDouble(stack.pop());
                double number0 = 0;
                switch (token) {
                    case "+":
                        number0 = number1 + number2;
                        break;
                    case "-":
                        number0 = number1 - number2;
                        break;
                    case "*":
                        number0 = number1 * number2;
                        break;
                    case "/":
                        if (Double.compare(number2, 0) == 0) {
                            System.out.println("Error when divide zero !");
                            return null;
                        }
                        number0 = number1 / number2;
                        break;
                    default:
                        break;
                }
                stack.push(number0 + "");
            }
        }
        infix.clear();
        infix.add(stack.peek());
        return Double.parseDouble(stack.pop());
    }
}
