package hw2_21000699_dangngocquan.exercise003.components;

import hw2_21000699_dangngocquan.exercise003.models.Card;

public class ViewCard extends Panel implements Comparable<ViewCard> {
    private Card card;

    public ViewCard(int x, int y, int width, int height, Card card) {
        super(x, y, width, height, null, card.getImage(), "");
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public int compareTo(ViewCard o) {
        return card.compareTo(o.getCard());
    }
}
