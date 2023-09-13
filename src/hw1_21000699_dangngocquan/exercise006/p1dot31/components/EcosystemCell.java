package hw1_21000699_dangngocquan.exercise006.p1dot31.components;

import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;

import java.awt.*;

public class EcosystemCell extends BasicPanel {
    public EcosystemCell(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.BORDER_COLOR_ECOSYSTEM_CELL);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Config.BACKGROUND_COLOR_ECOSYSTEM_CELL);
        g.fillRect(1, 1, this.getWidth()-2, this.getHeight()-2);
    }
}
