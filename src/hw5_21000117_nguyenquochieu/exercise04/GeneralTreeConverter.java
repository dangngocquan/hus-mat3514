package hw5_21000117_nguyenquochieu.exercise04;

import java.util.*;

public class GeneralTreeConverter<E> {
    public GeneralTreeConverter() {
    }

    public GeneralTreeNode<E> find(GeneralTreeNode<E> root, E element) {
        GeneralTreeNode<E> foundNode = null;
        Queue<GeneralTreeNode<E>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                GeneralTreeNode<E> node = queue.poll();
                if (node.getData().equals(element)) {
                    foundNode = node;
                    break;
                }
                if (node.getChild() != null) {
                    for (GeneralTreeNode child : node.getChild()) {
                        queue.add(child);
                    }
                }

                size--;
            }
        }
        return foundNode;
    }

    public GeneralTreeNode<E> convert(GeneralTreeNode<E> root, E element) {
        GeneralTreeNode<E> foundNode = find(root, element);
        if (foundNode != null) {
            if (!foundNode.getData().equals(root.getData())) {
                foundNode.setRoot();
                return foundNode;
            } else return root;
        }
        return null;
    }

    public void print(GeneralTreeNode<E> root) {
        if (root != null) {
            Queue<GeneralTreeNode<E>> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    GeneralTreeNode<E> node = queue.poll();
                    if (node.getChild() != null) {
                        for (GeneralTreeNode child : node.getChild()) {
                            queue.add(child);
                            System.out.println(node.getData() + " -> " + child.getData());
                        }
                    }
                    size--;
                }
            }
        } else {
            System.out.println("Root is null");
        }

    }
}
