package hw5_21000117_nguyenquochieu.exercise05;

public class Main {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        Tree tree = new Tree(data);
        Printer printer = new Printer(1);
        printer.print(tree.getRoot());
    }
}
