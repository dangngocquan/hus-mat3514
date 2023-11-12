package hw5_21000689_nguyenxuanloi.exercise.ex4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TreeNode<E> {
    E element;
    TreeNode<E> parent;
    List<TreeNode<E>> child;

    public TreeNode(E element) {
        this.element = element;
        this.parent = null;
        this.child = new ArrayList<>();
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public List<TreeNode<E>> getChild() {
        return child;
    }

    public void setChild(List<TreeNode<E>> child) {
        this.child = child;
    }

    public void print(StringBuilder sb, String prefix, String childrenPrefix) {
        sb.append(prefix).append(getElement()).append('\n');
        for (Iterator<TreeNode<E>> it = getChild().iterator(); it.hasNext(); ) {
            TreeNode<E> next = it.next();
            if (it.hasNext()) {
                next.print(sb, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(sb, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}

public class LinkedTree<E> {
    TreeNode<E> root;

    public TreeNode<E> root() {
        return root;
    }
    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }
    public TreeNode<E> addRoot(E element) {
        if (root != null) {
            System.out.println("Root is already extant.");
            return null;
        }
        root = new TreeNode<>(element);
        return root;
    }
    @SafeVarargs
    public final void addChild(TreeNode<E> p, E... elements) {
        if (p == null) {
            System.out.println("Node doesn't exist.");
        } else {
            for (E element: elements) {
                TreeNode<E> addedNode = new TreeNode<>(element);
                addedNode.setParent(p);
                p.child.add(addedNode);
            }
        }
    }

    public void set(TreeNode<E> p, E element) {
        p.setElement(element);
    }

    public void simplePrint() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevel(root, i);
            System.out.println();
        }
        System.out.println();
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        root.print(sb, "", "");
        System.out.println(sb.toString());
    }

    public int height(TreeNode<E> root) {
        if (root == null) {
            return 0;
        } else if (root.getChild().isEmpty()) {
            return 1;
        } else {
            int maxHeight = 0;
            for (int i = 0; i < root.getChild().size(); i++) {
                maxHeight = Math.max(maxHeight, height(root.getChild().get(i)) + 1);
            }
            return maxHeight;
        }
    }

    public int depth(TreeNode<E> p) {
        if (p == null) {
            return 0;
        }
        int depth = 1;
        TreeNode<E> temp = p;
        while (temp.getParent() != null) {
            temp = temp.getParent();
            depth++;
        }
        return depth;
    }

    void printLevel(TreeNode<E> root, int level) {
        if (root == null || level <= 0) {
            System.out.println("Tree doesn't exist or invalid level.");
        } else if (level == 1) {
            System.out.print(root.getElement() + " ");
        } else {
            for (int i = 0; !root.getChild().isEmpty() && i < root.getChild().size(); i++) {
                printLevel(root.getChild().get(i), level - 1);
            }
        }
    }
}
