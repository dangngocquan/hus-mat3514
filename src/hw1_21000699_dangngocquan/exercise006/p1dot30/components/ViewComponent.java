package hw1_21000699_dangngocquan.exercise006.p1dot30.components;

import hw1_21000699_dangngocquan.exercise006.p1dot30.Config;
import hw1_21000699_dangngocquan.exercise006.p1dot30.models.AlphabetCharacter;
import hw1_21000699_dangngocquan.exercise006.p1dot30.services.Service;

import java.awt.*;
import java.util.Collections;
import java.util.List;

public class ViewComponent extends BasicPanel {
    public ViewComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Config.VIEW_COMPONENT_BACKGROUND_COLOR);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void renderBarChart(String text) {
        this.removeAll();
        List<AlphabetCharacter> alphabetCharacters = Service.getListFrequenciesCharacter(text);
        Collections.sort(alphabetCharacters);
        int maxCount = alphabetCharacters.get(0).getCount();
        if (maxCount == 0) maxCount = 1;
        for (int i = 0; i < 26; i++) {
            this.add(
                    new Bar(20 + Config.BAR_WIDTH * i,
                            20,
                            (Config.BAR_HEIGHT - 60) * alphabetCharacters.get(i).getCount() / maxCount,
                            alphabetCharacters.get(i))
            );
        }
        repaint();
    }


}
