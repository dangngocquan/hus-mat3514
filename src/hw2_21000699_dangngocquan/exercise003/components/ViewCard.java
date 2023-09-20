package hw2_21000699_dangngocquan.exercise003.components;

import hw2_21000699_dangngocquan.exercise003.models.Card;

public class ViewCard extends Panel {
    private Card card;

    public ViewCard(int x, int y, int width, int height, Card card) {
        super(x, y, width, height, null, card.getImage(), "");
        this.card = card;
    }


}
