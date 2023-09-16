package hw1_21000699_dangngocquan.exercise006.p2dot30.components;

import hw1_21000699_dangngocquan.exercise006.p2dot30.Config;
import hw1_21000699_dangngocquan.exercise006.p2dot30.models.AlphabetCharacter;

import java.awt.*;

public class Bar extends BasicPanel {
    private AlphabetCharacter alphabetCharacter;
    private int fillHeight;

    public Bar(int x, int y, int fillHeight, AlphabetCharacter alphabetCharacter) {
        super(x, y, Config.BAR_WIDTH, Config.BAR_HEIGHT);
        this.alphabetCharacter = alphabetCharacter;
        this.fillHeight = fillHeight;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int topY = 30 + (Config.BAR_HEIGHT-60) - this.fillHeight;
        g.setColor(Config.BAR_BACKGROUND_COLOR);
        g.fillRect(3, topY,
                this.getWidth()-6, this.fillHeight);
        g.drawString(alphabetCharacter.getCharacter() + "", Config.BAR_WIDTH / 2, Config.BAR_HEIGHT - 5);
        g.drawString(alphabetCharacter.getCount() + "", Config.BAR_WIDTH/2-3, topY-20);
        g.drawString(String.format("%.2f%%", alphabetCharacter.getFrequency()*100), 10, topY - 10);
    }
}
