package hw5_21000117_nguyenquochieu.sessionC.practice20;

public class Tree {
    private int data;
    private Tree left;
    private Tree right;
    public Tree(int d){
        data=d;
        left=null;
        right=null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

}
