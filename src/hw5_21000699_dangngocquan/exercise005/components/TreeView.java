package hw5_21000699_dangngocquan.exercise005.components;

import hw5_21000699_dangngocquan.exercise005.App;
import hw5_21000699_dangngocquan.exercise005.Config;
import hw5_21000699_dangngocquan.exercise005.components.base.Panel;
import hw5_21000699_dangngocquan.exercise005.models.LinkedBinaryTree;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class TreeView extends Panel {
    public App app;
    public static int GAP_X = 10;
    public static int GAP_Y = 40;
    public LinkedBinaryTree<PanelTreeNode> tree;
    private static int column;

    public TreeView(String inputData, App app) {
        super(
                0, 0,
                Config.WIDTH, Config.HEIGHT/5*4,
                Config.BACKGROUND_COLOR_APP,
                null, "", 0
        );
        this.app = app;
        createTree(inputData);
        column = 0;
        reformatPanelsTreeNode(tree.root(), 0);
        repaint();
    }

    public void updateTree(String newData) {
        removeAll();
        repaint();
        createTree(newData);
        column = 0;
        reformatPanelsTreeNode(tree.root(), 0);
        repaint();
    }

    public void createTree(String inputData) {
        String[] lines = inputData.split("\n");
        tree = new LinkedBinaryTree<>();
        Queue<LinkedBinaryTree.Node<PanelTreeNode>> queue = new LinkedList<>();
        queue.add(tree.addRoot(new PanelTreeNode(0, 0, lines[0])));
        add(tree.elementOfNode(tree.root()));
        tree.elementOfNode(tree.root()).node = tree.root();
        int row = 1;
        int column;
        int indexLine = 1;
        while (!queue.isEmpty() && indexLine < lines.length) {
            int k = queue.size(); // number of nodes in current row
            column = 0;
            while (k-- > 0 && indexLine < lines.length) {
                LinkedBinaryTree.Node<PanelTreeNode> parentNode = queue.poll();
                String[] elements = lines[indexLine++].trim().split(" ");
                if (elements.length == 0) elements = new String[] {"N" , "N"};
                if (elements.length == 1) elements = new String[] {elements[0], "N"};
                if (elements[0].equals("N")) {
                    column++;
                } else {
                    PanelTreeNode leftPanelNode = new PanelTreeNode(row, column++, elements[0]);
                    LinkedBinaryTree.Node<PanelTreeNode> leftNode = tree.addLeft(parentNode, leftPanelNode);
                    queue.add(leftNode);
                    add(leftPanelNode);
                    leftPanelNode.node = leftNode;
                }
                if (elements[1].equals("N")) {
                    column++;
                } else {
                    PanelTreeNode rightPanelNode = new PanelTreeNode(row, column++, elements[1]);
                    LinkedBinaryTree.Node<PanelTreeNode> rightNode = tree.addRight(parentNode, rightPanelNode);
                    queue.add(rightNode);
                    add(rightPanelNode);
                    rightPanelNode.node = rightNode;
                }
            }
            row++;
        }
    }

    public void reformatPanelsTreeNode(LinkedBinaryTree.Node<PanelTreeNode> node, int row) {
        if (node == null) return;
        reformatPanelsTreeNode(node.left, row+1);
        tree.elementOfNode(node).setRowAndColumn(row, column);
        column++;
        reformatPanelsTreeNode(node.right, row+1);
    }

    public void paintComponent(Graphics g) {
        Queue<LinkedBinaryTree.Node<PanelTreeNode>> queue = new LinkedList<>();
        queue.add(tree.root());
        while (!queue.isEmpty()) {
            int k = queue.size(); // number of nodes in current row
            while (k-- > 0) {
                LinkedBinaryTree.Node<PanelTreeNode> node = queue.poll();
                assert node != null;
                if (node.left != null) {
                    g.drawLine(
                            tree.elementOfNode(node).getX() + Config.NODE_SIZE / 2,
                            tree.elementOfNode(node).getY() + Config.NODE_SIZE,
                            tree.elementOfNode(node.left).getX() + Config.NODE_SIZE / 2,
                            tree.elementOfNode(node.left).getY());
                    queue.add(node.left);
                }
                if (node.right != null) {
                    g.drawLine(
                            tree.elementOfNode(node).getX() + Config.NODE_SIZE / 2,
                            tree.elementOfNode(node).getY() + Config.NODE_SIZE,
                            tree.elementOfNode(node.right).getX() + Config.NODE_SIZE / 2,
                            tree.elementOfNode(node.right).getY());
                    queue.add(node.right);
                }

            }
        }
    }
}
