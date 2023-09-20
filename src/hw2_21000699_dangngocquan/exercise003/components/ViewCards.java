package hw2_21000699_dangngocquan.exercise003.components;

import hw2_21000699_dangngocquan.exercise003.Config;
import hw2_21000699_dangngocquan.exercise003.models.Card;
import hw2_21000699_dangngocquan.exercise003.services.Service;
import hw2_21000699_dangngocquan.exercise003.services.animation.Animation;

import javax.swing.*;
import java.awt.*;

public class ViewCards extends Panel {
    private ViewCard[] viewCards = null;
    private int widthPerCard;
    private double dx;
    private double scale;

    public ViewCards(int x, int y, int width, int height, Color backgroundColor, ImageIcon backgroundImage, String text) {
        super(x, y, width, height, backgroundColor, backgroundImage, text);
        addViewCards();
    }

    public void addViewCards() {
        if (viewCards == null) {
            Card[] cards = Service.createCards();
            viewCards = new ViewCard[cards.length];
            widthPerCard = (int) (Config.WIDTH_OF_CARD / 3);
            dx = (Config.WIDTH - widthPerCard - 20) * 1.0 / (cards.length - 1);
            scale = widthPerCard * 1.0 / Config.WIDTH_OF_CARD;
            for (int i = 0; i < viewCards.length; i++) {
                viewCards[i] = new ViewCard(
                        (int) (dx * i + 10), 10,
                        widthPerCard, (int) (Config.HEIGHT_OF_CARD * scale),
                        cards[i]
                );
                add(viewCards[i]);
            }
            shuffleCards();
        }
    }

    public void shuffleCards() {
        Service.shuffleCards(viewCards);
        for (int i = 0; i < viewCards.length; i++) {
            viewCards[i].setXY((int) (dx * i + 10), 10);
            this.setComponentZOrder(viewCards[i], viewCards.length-1-i);
        }
        Service.swapViewCards(viewCards, 10, 41, dx);
        Service.swapViewCards(viewCards, 1, 51, dx);
    }
}
