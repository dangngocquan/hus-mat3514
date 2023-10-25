package hw5_21000699_dangngocquan.exercise005.components;

import hw5_21000699_dangngocquan.exercise005.Config;
import hw5_21000699_dangngocquan.exercise005.components.base.Panel;
import hw5_21000699_dangngocquan.exercise005.components.base.TextArea;

import javax.swing.*;
import java.awt.*;

public class ControllerView extends Panel {
    public TextArea textArea;
    public ControllerView() {
        super(
                0, Config.HEIGHT/5*4,
                Config.WIDTH, Config.HEIGHT - Config.HEIGHT/5*4,
                Config.BACKGROUND_COLOR_APP,
                null, "", 0
        );
        addDescription();
        addTextArea();
        repaint();
    }

    public void addDescription() {
        Panel panel = new Panel(
                0, 0, getWidthPanel(), 50,
                Config.BACKGROUND_COLOR_APP, null,
                "Line 1 is element of node 0 (root of tree). Line i (i >= 1) is left node and right node of node i-1. " +
                        "Enter \"N\" if the node is null.",
                0);
        panel.setFont(Config.MONOSPACE_BOLD_16);
        add(panel);
    }

    public void addTextArea() {
        this.textArea = new TextArea(
                0, 0,
                getWidthPanel() - 40, getHeightPanel() - 70,
                2, 0, 0);
        textArea.setText("1\n2 3\n4 5\n6 7\nN 8\n9 N\n10 11\nN 12\nN 13\n14 N\n15 N\nN 16\nN 17");
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(
                20, 50,
                getWidthPanel() - 40, getHeightPanel() - 70);
        scrollPane.setMaximumSize(new Dimension(getWidthPanel()-40, getHeightPanel() * 10));
        scrollPane.setMinimumSize(new Dimension(getWidthPanel()-40, getHeightPanel() * 10));
        add(scrollPane);
    }
}
