package hw1_21000699_dangngocquan.exercise006.p1dot31.components;

import hw1_21000699_dangngocquan.exercise006.p1dot31.App;
import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;
import hw1_21000699_dangngocquan.exercise006.p1dot31.models.Animal;
import hw1_21000699_dangngocquan.exercise006.p1dot31.services.Service;

import java.awt.*;

public class EcosystemView extends BasicPanel {
    private BasicPanel ecosystemTable = null;
    public EcosystemView(int x, int y, int width, int height, int ecosystemSize) {
        super(x, y, width, height);

        addEcosystemTable(ecosystemSize);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.BACKGROUND_COLOR_ECOSYSTEM_VIEW);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void addEcosystemTable(int size) {
        this.ecosystemTable = new EcosystemTable (
                (Config.WIDTH_ECOSYSTEM_VIEW_COMPONENT - Config.WIDTH_ECOSYSTEM_TABLE) / 2,
                10,
                Config.WIDTH_ECOSYSTEM_TABLE,
                Config.HEIGHT_ECOSYSTEM_TABLE,
                size
        );
        this.add(ecosystemTable);
    }
}
