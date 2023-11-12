package hw5_21000117_nguyenquochieu.exercise04;

import java.util.*;

public class GeneralTreeNode<E> {
    private E data;
    private List<GeneralTreeNode<E>> child;
    private GeneralTreeNode<E> parent;

    public GeneralTreeNode(E data) {
        this.data = data;

    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }


    public void addChild(GeneralTreeNode<E> node) {
        if (child == null) child = new ArrayList<>();
        child.add(node);
        node.parent = this;
    }

    public List<GeneralTreeNode<E>> getChild() {
        return child;
    }

    public void detach() {
        if (this.parent != null) {
            this.parent.child.remove(this);
            this.parent = null;
        }
    }

    public void setRoot() {
        GeneralTreeNode<E> node = this.parent;
        if (node != null) {
            node.setRoot();
            this.detach();
            this.addChild(node);
        }
    }

    @Override
    public String toString() {
        return "{Node: data = " + data + "}";
    }
}