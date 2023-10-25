package hw5_21000699_dangngocquan.exercise004;


import hw5_21000699_dangngocquan.exercise004.components.ControllerView;
import hw5_21000699_dangngocquan.exercise004.components.TreeView;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class App extends JFrame {
    public ControllerView controllerView;
    public TreeView treeView;

    public App() {
        super("Homework 5 - Exercise 4 - P8.68");
        setSize(Config.DEVICE_WIDTH, Config.DEVICE_HEIGHT);
        setResizable(false);
        setAlwaysOnTop(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBackground(Config.BACKGROUND_COLOR_APP);
        setFont(Config.MONOSPACE_BOLD_16);

        addControllerView();
        addTreeView();
        addListeners();

        setVisible(true);
    }

    public void addControllerView() {
        this.controllerView = new ControllerView();
        add(controllerView);
    }

    public void addTreeView() {
        this.treeView = new TreeView(controllerView.textArea.getText(), this);
        add(treeView);
    }

    public void addListeners() {
        controllerView.textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                treeView.updateTree(controllerView.textArea.getText());
                repaint();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                treeView.updateTree(controllerView.textArea.getText());
                repaint();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                treeView.updateTree(controllerView.textArea.getText());
                repaint();
            }
        });
    }
}
