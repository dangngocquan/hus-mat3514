package hw5_21000117_nguyenquochieu.sessionA.practice3;


public class Main {
    /*
You can test program by running this code below.
To check the solution, please use the code in Solution file
 */
    public static void main(String[] args) {
        int[] data = {3, 4, 2, 5, 6, 2, 1, 4};
        Tree tree = new Tree(data);
        System.out.println(tree);
        System.out.println("Number of leaves: " + tree.getNumLeaves());
    }

}
