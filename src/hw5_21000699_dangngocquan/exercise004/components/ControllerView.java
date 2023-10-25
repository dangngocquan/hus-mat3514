package hw5_21000699_dangngocquan.exercise004.components;

import hw5_21000699_dangngocquan.exercise004.Config;
import hw5_21000699_dangngocquan.exercise004.components.base.Panel;
import hw5_21000699_dangngocquan.exercise004.components.base.TextArea;

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
                "Line 1 is element of node 0 (root of tree). Line i (i >= 1) is children of node i-1. " +
                        "Click a node, that node will become the root of tree.",
                0);
        panel.setFont(Config.MONOSPACE_BOLD_16);
        add(panel);
    }

    public void addTextArea() {
        this.textArea = new TextArea(
                0, 0,
                getWidthPanel() - 40, getHeightPanel() - 70,
                2, 0, 0);
        textArea.setText("1\n2 3 4\n5 6 7\n8 9\n10 11 12\n13\n\n14 15 16 17");
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(
                20, 50,
                getWidthPanel() - 40, getHeightPanel() - 70);
        scrollPane.setMaximumSize(new Dimension(getWidthPanel()-40, getHeightPanel() * 10));
        scrollPane.setMinimumSize(new Dimension(getWidthPanel()-40, getHeightPanel() * 10));
        add(scrollPane);
    }
}
