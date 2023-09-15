package hw1_21000699_dangngocquan.exercise006.p1dot32.components;

import hw1_21000699_dangngocquan.exercise006.p1dot32.App;
import hw1_21000699_dangngocquan.exercise006.p1dot32.Config;
import hw1_21000699_dangngocquan.exercise006.p1dot32.components.BasicPanel;
import hw1_21000699_dangngocquan.exercise006.p1dot32.components.EcosystemTable;
import hw1_21000699_dangngocquan.exercise006.p1dot32.models.Animal;
import hw1_21000699_dangngocquan.exercise006.p1dot32.services.Service;

import java.awt.*;

public class EcosystemView extends BasicPanel {
    private BasicPanel ecosystemTable = null;
    public EcosystemView(
            int x, int y,
            int width, int height,
            int ecosystemSize, int initialNumberBear, int initialNumberFish) {
        super(x, y, width, height);

        addEcosystemTable(ecosystemSize, initialNumberBear, initialNumberFish);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.BACKGROUND_COLOR_ECOSYSTEM_VIEW);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void addEcosystemTable(int size, int initialNumberBear, int initialNumberFish) {
            this.ecosystemTable = new EcosystemTable(
                    (Config.WIDTH_ECOSYSTEM_VIEW_COMPONENT - Config.WIDTH_ECOSYSTEM_TABLE) / 2,
                    10,
                    Config.WIDTH_ECOSYSTEM_TABLE,
                    Config.HEIGHT_ECOSYSTEM_TABLE,
                    size,
                    initialNumberBear,
                    initialNumberFish
            );
            this.add(ecosystemTable);
    }

    public void rerenderWithInitialDataInput(int ecosystemSize, int initialNumberBear, int initialNumberFish) {
        removeAll();
        addEcosystemTable(ecosystemSize, initialNumberBear, initialNumberFish);
        repaint();
    }

    public void runEcosystem() {
        ((EcosystemTable) ecosystemTable).runEcosystem();
    }

    public void stopEcosystem() {
        ((EcosystemTable) ecosystemTable).stopEcosystem();
    }
}
