package hw4_21000117_nguyenquochieu.exercise02;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test Array Stack");
        testArrayStack();
        System.out.println("------------------");
        System.out.println("Test Linked List Stack");
        testLinkedListStack();
        System.out.println("-------------------");
    }
    private static void testArrayStack() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("Hello");
        arrayStack.push("This");
        arrayStack.push("is");
        arrayStack.push("a");
        arrayStack.push("testing");
        arrayStack.push("program");
        System.out.println("All elements in the stack: ");
        for (String element : arrayStack) System.out.println(element);
        System.out.println("Top element: " + arrayStack.top());
        System.out.println("Remove top element: " + arrayStack.pop());
        System.out.println("All elements in the stack: ");
        for (String element : arrayStack) System.out.println(element);
    }

    private static void testLinkedListStack() {
        LinkedListStack<String> linkedListStack = new LinkedListStack<>();
        linkedListStack.push("Hello");
        linkedListStack.push("This");
        linkedListStack.push("is");
        linkedListStack.push("a");
        linkedListStack.push("testing");
        linkedListStack.push("program");
        System.out.println("All elements in the stack: ");
        for (String element : linkedListStack) System.out.println(element);
        System.out.println("Top element: " + linkedListStack.top());
        System.out.println("Remove top element: " + linkedListStack.pop());
        System.out.println("All elements in the stack: ");
        for (String element : linkedListStack) System.out.println(element);
    }
}
