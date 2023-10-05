package hw4_21000699_dangngocquan.exercise002;

public class Test {
    public void run() {
        testArrayStack();
        testLinkedListStack();
    }

    public void testArrayStack() {
        System.out.println("\nTEST ARRAY STACK");
        StackInterface stack = new ArrayStack();
        testStack(stack);
    }

    public void testLinkedListStack() {
        System.out.println("\nTEST LINKED LIST STACK");
        StackInterface stack = new LinkedListStack();
        testStack(stack);
    }

    public void testStack(StackInterface stack) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "Action",
                "Return",
                "Stack"
        );
        System.out.println("\t---------------------------------------------------------");
        testEmpty(stack);
        testSize(stack);
        testPush(stack, 1);
        testPush(stack, 2);
        testPop(stack);
        testEmpty(stack);
        testTop(stack);
        testPush(stack, 3);
        testTop(stack);
        testPush(stack, 4);
        testPop(stack);


    }

    public void testPush(StackInterface stack, Object o) {
        stack.push(o);
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                String.format("stack.push(%s)", o),
                "",
                stack
        );
    }

    public void testPop(StackInterface stack) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "stack.pop()",
                stack.pop(),
                stack
        );
    }

    public void testTop(StackInterface stack) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "stack.top()",
                stack.top(),
                stack
        );
    }

    public void testSize(StackInterface stack) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "stack.size()",
                stack.size(),
                stack
        );
    }

    public void testEmpty(StackInterface stack) {
        System.out.printf(
                "\t%-20s %-15s %-100s\n",
                "stack.isEmpty()",
                stack.isEmpty(),
                stack
        );
    }

}
