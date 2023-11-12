package hw5_21000117_nguyenquochieu.sessionB.practice11;

public class Main {
    /*
    You can test program by running this code below.
    To check the solution, please use the code in Solution file
     */
    public static void main(String[] args) {
        int[] data = {1, 3, 4, 2, 6, 7};
        Tree tree = new Tree(data);
        System.out.println("Tree: ");
        System.out.println(tree);
        System.out.println("In-order traversal: ");
        tree.traversal();
    }
}
