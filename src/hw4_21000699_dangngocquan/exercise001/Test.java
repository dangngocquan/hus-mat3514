package hw4_21000699_dangngocquan.exercise001;

import java.util.Scanner;

public class Test {
    public void run() {
        String fullName = getInput();
        showCodeExecute();
        showOutput(fullName);
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your full name");
        System.out.printf("%-12s: ", "INPUT");
        String fullName = scanner.nextLine();
        scanner.close();
        return fullName;
    }

    public void showCodeExecute() {
        System.out.println("\nCODE EXECUTE: ");
        System.out.printf(
                "%s\n%s\n%s\n%s\n%s\n\n",
                "\tMyStack stack = new MySinglyLinkedListStack();",
                "\tfor (int i = 0; i < fullName.length(); i++) {",
                "\t\tif (i % 2 == 0) stack.push(fullName.charAt(i));",
                "\t\tif (i % 3 == 0) stack.pop();",
                "\t}"
        );
    }

    public void showOutput(String fullName) {
        System.out.printf("%-12s:\n", "RUNTIME");
        System.out.printf(
                "\t%-5s %-15s %-100s\n",
                "i",
                "Action",
                "Stack"
        );
        System.out.println("\t------------------------------------------");

        MyStack stack = new MySinglyLinkedListStack();
        for (int i = 0; i < fullName.length(); i++) {
            boolean hasChanged = false;
            if (i % 2 == 0) {
                stack.push(fullName.charAt(i));
                System.out.printf(
                        "\t%-5d %-15s %-100s\n",
                        i,
                        String.format("stack.push(%s)", fullName.charAt(i)),
                        stack
                );
                hasChanged = true;
            }
            if (i % 3 == 0) {
                stack.pop();
                System.out.printf(
                        "\t%-5d %-15s %-100s\n",
                        i,
                        "stack.pop()",
                        stack
                );
                hasChanged = true;
            }

            if (!hasChanged) {
                System.out.printf(
                        "\t%-5d %-15s %-100s\n",
                        i,
                        "none",
                        stack
                );
            }

        }
        System.out.printf("\n%-12s: %s", "OUTPUT", stack);
    }
}
