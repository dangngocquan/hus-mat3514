package hw1_21000699_dangngocquan.exercise006.p1dot32.components;

import hw1_21000699_dangngocquan.exercise006.p1dot32.Config;
import hw1_21000699_dangngocquan.exercise006.p1dot32.components.BasicPanel;
import hw1_21000699_dangngocquan.exercise006.p1dot32.models.Animal;

import java.awt.*;

public class EcosystemCell extends BasicPanel {
    private Animal animal = null;
    public EcosystemCell(int x, int y, int width, int height, Animal animal) {
        super(x, y, width, height);
        this.animal = animal;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.BORDER_COLOR_ECOSYSTEM_CELL);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Config.BACKGROUND_COLOR_ECOSYSTEM_CELL);
        g.fillRect(1, 1, this.getWidth()-2, this.getHeight()-2);

        if (animal != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            if (animal != null) {
                g2.drawImage(animal.getImage().getImage(),
                        2, 2, getWidth()-4,
                        getHeight()-4, null);
            }


            g.setColor(Config.COLOR_TEXT);
            g.setFont(new Font("Arial", Font.PLAIN, getHeight() / 5 + 1));
            if (animal != null) {
                g.drawString(animal.getStrength() + "", 1, getHeight() / 5 + 1);
            }
        }
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
