package hw1_21000699_dangngocquan.exercise006.p1dot31.components;

import hw1_21000699_dangngocquan.exercise006.p1dot31.Config;

import java.awt.*;

public class EcosystemTable extends BasicPanel {
    private int size;
    private EcosystemCell[][] ecosystemCells = null;
    public EcosystemTable(int x, int y, int width, int height, int size) {
        super(x, y, width/size * size, height / size * size);
        this.size = size;
        this.ecosystemCells = new EcosystemCell[size][size];

        addEcosystemCells();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.BACKGROUND_COLOR_ECOSYSTEM_TABLE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void addEcosystemCells() {
        int sizeCell = getWidth() / size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ecosystemCells[i][j] = new EcosystemCell(
                        j * sizeCell,
                        i * sizeCell,
                        sizeCell,
                        sizeCell
                );
                this.add(ecosystemCells[i][j]);
            }
        }
    }
}
