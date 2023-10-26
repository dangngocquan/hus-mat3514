package hw4_21000676_damhaidang.practice1.ex13;

import java.util.Iterator;
import java.util.Scanner;

class Node {
    String element;
    Node next;
    public Node(String element) {
        this.element = element;
    }
}

class LinkedListStack implements Iterable<String>{
    private Node top;
    public void push(String element) {
        Node node = new Node(element);
        if (top != null) {
            node.next = top;
        }
        top = node;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Node currentNode = top;

            @Override
            public boolean hasNext() {

                return currentNode != null;
            }

            @Override
            public String next() {
                String data = currentNode.element;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

}
public class Exercise13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.substring(i, i + 1));
        }

        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
