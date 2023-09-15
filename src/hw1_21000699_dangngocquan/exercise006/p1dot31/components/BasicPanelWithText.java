package hw1_21000699_dangngocquan.exercise006.p1dot31.components;

import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;

import java.awt.*;

public class BasicPanelWithText extends BasicPanel {
    private String text = "";

    public BasicPanelWithText(int x, int y, int width, int height, String text) {
        super(x, y, width, height);
        this.text = text;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.BACKGROUND_COLOR_CONTROLLER_VIEW);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Config.COLOR_TEXT);
        g.setFont(Config.ARIAL_BOLD_12);
        g.drawString(text, 0, getHeight() / 2 + 6);
    }

    public void setText(String text) {
        this.text = text;
        repaint();
    }
}
