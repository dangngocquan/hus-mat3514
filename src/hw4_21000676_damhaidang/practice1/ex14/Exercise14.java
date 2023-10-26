package hw4_21000676_damhaidang.practice1.ex14;

import java.util.Iterator;
import java.util.Scanner;

class Node {
    String element;

    Node next;

    public Node(String element) {
        this.element = element;
    }
}

class LinkedListStack implements Iterable<String> {
    private
    Node top;

    public void push(String element) {

        Node node = new
                Node(element);
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

public class Exercise14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        LinkedListStack stack = new LinkedListStack();
        while (input != 0) {
            stack.push(String.valueOf(input % 2));
            input = input / 2;
        }

        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
