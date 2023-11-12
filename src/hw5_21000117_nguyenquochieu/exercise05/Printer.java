package hw5_21000117_nguyenquochieu.exercise05;

public class Printer {
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private int state;
    private StringBuilder treeBuilder = new StringBuilder();

    public Printer(int state) {
        this.state = state;
    }

    public void print(Tree.Node root) {
        if (state == HORIZONTAL) {
            printHorizontalTree(root, 10);
            System.out.println(treeBuilder.toString());
        } else if (state == VERTICAL) {
            printVerticalTree(root, 10);
            System.out.println(treeBuilder.toString());
        } else {
            System.out.println("INVALID SYNTAX!");
            System.exit(1);
        }
    }

    private void printHorizontalTree(Tree.Node root, int space) {
        if (root != null) {
            space += 10;
            printHorizontalTree(root.getRight(), space);
            treeBuilder.append("\n");
            for (int i = 10; i < space; i++)
                treeBuilder.append(" ");
            treeBuilder.append(root.getData() + "\n");
            printHorizontalTree(root.getLeft(), space);
        }
    }

    private void printVerticalTree(Tree.Node root, int space) {
        int height = Tree.getHeight(root);
        int columns = columns(height);
        int[][] treeMatrix = new int[height][columns];
        printVerticalTree(treeMatrix, root, columns / 2, 0, height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < columns; j++) {
                if (treeMatrix[i][j] == 0)
                    for (int k = 0; k < space; k++) treeBuilder.append(" ");
                else {
                    treeBuilder.append(treeMatrix[i][j]);
                    for (int k = 0; k < space / 2; k++) treeBuilder.append(" ");
                }
            }
            treeBuilder.append("\n").append("\n").append("\n");
        }
    }

    private void printVerticalTree(int[][] matrix, Tree.Node root, int col, int row, int height) {
        if (root == null)
            return;
        matrix[row][col] = root.getData();
        printVerticalTree(matrix, root.getLeft(), col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printVerticalTree(matrix, root.getRight(), col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }

    private int columns(int height) {
        if (height == 1) return 1;
        return 2 * columns(height - 1) + 1;
    }
}
