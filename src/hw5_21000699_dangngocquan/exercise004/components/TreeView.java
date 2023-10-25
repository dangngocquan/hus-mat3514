package hw5_21000699_dangngocquan.exercise004.components;

import hw5_21000699_dangngocquan.exercise004.App;
import hw5_21000699_dangngocquan.exercise004.Config;
import hw5_21000699_dangngocquan.exercise004.components.base.Panel;
import hw5_21000699_dangngocquan.exercise004.models.LinkedGeneralTree;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class TreeView extends Panel {
    public App app;
    public static int GAP_X = 10;
    public static int GAP_Y = 40;
    public LinkedGeneralTree<PanelTreeNode> tree;
    public TreeView(String inputData, App app) {
        super(
                0, 0,
                Config.WIDTH, Config.HEIGHT/5*4,
                Config.BACKGROUND_COLOR_APP,
                null, "", 0
        );
        this.app = app;
        createTree(inputData);
        reformatPanelsTreeNode(tree.root(), 0, 0);
        repaint();
    }

    public void updateTree(String newData) {
        removeAll();
        repaint();
        createTree(newData);
        reformatPanelsTreeNode(tree.root(), 0, 0);
        repaint();
    }

    // Sample
    // 1
    // 11 12 13
    // 111 112
    // 121 122 123
    // 131 132
    // 1111 1112 1113 1114
    //
    // 1311 1312

    // Tree will like that:
    // 1
    // 11                   12           13
    // 111 112              121 122 123  131        132
    // 1111 1112 1113 1114               1311 1312
    public void createTree(String inputData) {
        String[] lines = inputData.split("\n");
        tree = new LinkedGeneralTree<>();
        Queue<LinkedGeneralTree.Node<PanelTreeNode>> queue = new LinkedList<>();
        queue.add(tree.addRoot(new PanelTreeNode(0, 0, lines[0])));
        add(tree.getElementOfNode(tree.root()));
        tree.getElementOfNode(tree.root()).node = tree.root();
        int row = 1;
        int column;
        int indexLine = 1;
        while (!queue.isEmpty() && indexLine < lines.length) {
            int k = queue.size(); // number of nodes in current row
            column = 0;
            while (k-- > 0 && indexLine < lines.length) {
                LinkedGeneralTree.Node<PanelTreeNode> parentNode = queue.poll();
                String[] elements = lines[indexLine++].trim().split(" ");
                for (String e : elements) {
                    if (e.isBlank()) {
                        column++;
                        continue;
                    }
                    PanelTreeNode childPanelNode = new PanelTreeNode(row, column++, e);
                    LinkedGeneralTree.Node<PanelTreeNode> newNode = tree.addChild(parentNode, childPanelNode);
                    queue.add(newNode);
                    add(childPanelNode);
                    childPanelNode.node = newNode;
                    childPanelNode.addActionListener(new TreeNodeListener());
                }
            }
            row++;
        }
    }

    public void reformatPanelsTreeNode(LinkedGeneralTree.Node<PanelTreeNode> node, int row, int column) {
        if (node == null) return;
        int n = tree.width(node);
        tree.getElementOfNode(node).setRowAndColumn(row, column + n/2);
        for (LinkedGeneralTree.Node<PanelTreeNode> child : tree.children(node)) {
            int n0 = tree.width(child);
            reformatPanelsTreeNode(child, row+1, column);
            column += n0;
        }
    }

    public String getInputData() {
        if (tree.root() == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<LinkedGeneralTree.Node<PanelTreeNode>> queue = new LinkedList<>();
        queue.add(tree.root());
        sb.append(tree.getElementOfNode(tree.root()).data).append("\n");
        while (!queue.isEmpty()) {
            LinkedGeneralTree.Node<PanelTreeNode> parent = queue.poll();
            for (LinkedGeneralTree.Node<PanelTreeNode> node : tree.children(parent)) {
                sb.append(tree.getElementOfNode(node).data).append(" ");
                queue.add(node);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void paintComponent(Graphics g) {
        Queue<LinkedGeneralTree.Node<PanelTreeNode>> queue = new LinkedList<>();
        queue.add(tree.root());
        while (!queue.isEmpty()) {
            int k = queue.size(); // number of nodes in current row
            while (k-- > 0) {
                LinkedGeneralTree.Node<PanelTreeNode> node = queue.poll();
                for (LinkedGeneralTree.Node<PanelTreeNode> child : tree.children(node)) {
                    g.drawLine(
                            tree.getElementOfNode(node).getX() + Config.NODE_SIZE / 2,
                            tree.getElementOfNode(node).getY() + Config.NODE_SIZE,
                            tree.getElementOfNode(child).getX() + Config.NODE_SIZE / 2,
                            tree.getElementOfNode(child).getY());
                    queue.add(child);
                }
            }
        }
    }

    private class TreeNodeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tree.modifyRoot(((PanelTreeNode) e.getSource()).node);
            app.controllerView.textArea.setText(getInputData());
            app.controllerView.textArea.setCaretPosition(0);
            app.repaint();
        }
    }
}
