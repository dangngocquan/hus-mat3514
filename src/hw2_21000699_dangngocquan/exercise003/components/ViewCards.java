package hw2_21000699_dangngocquan.exercise003.components;

import hw2_21000699_dangngocquan.exercise003.App;
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
        addViewCards(52, 12);
    }

    public void addViewCards(int numberCards, int maxRankCard) {
        removeAll();
        repaint();
        Card[] cards = Service.createCards(numberCards, maxRankCard);
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

    public App getApp() {
        return (App) (Service.getFrame(this));
    }

    public ViewCard[] getViewCards() {
        return viewCards;
    }

    public void updateViewCards() {
        for (int i = 0; i < viewCards.length; i++) {
            viewCards[i].setXY((int) (dx * i + 10), 10);
            this.setComponentZOrder(viewCards[i], viewCards.length-1-i);
        }
    }

    public void shuffleCards() {
        Service.shuffleCards(viewCards);
        updateViewCards();

    }

    public void pickAndSwapCards(int i1, int i2, int duration) {
        ViewCard viewCard1 = viewCards[i1];
        ViewCard viewCard2 = viewCards[i2];
        viewCards[i1] = viewCard2;
        viewCards[i2] = viewCard1;

        duration = duration - 20;
        int delay1 = 0;
        int duration1 = duration / 4;
        int delay2 = delay1 + duration1 + 10;
        int duration2 = duration / 2;
        int delay3 = delay2 + duration2 + 10;
        int duration3 = duration / 4;
        Animation.translate(viewCard1, 0, viewCard1.getHeight() / 4 * 5, delay1, duration1, viewCards.length-1-i1);
        Animation.translate(viewCard2, 0, viewCard2.getHeight() / 4 * 5, delay1, duration1, viewCards.length-1-i2);
        Animation.translate(viewCard1, (int) (dx * (i2 - i1)), 0, delay2, duration2, viewCards.length-1-i1);
        Animation.translate(viewCard2, (int) (dx * (i1 - i2)), 0, delay2, duration2, viewCards.length-1-i2);
        Animation.translate(viewCard1, 0, -viewCard1.getHeight() / 4 * 5, delay3, duration3, viewCards.length-1-i2);
        Animation.translate(viewCard2, 0, -viewCard2.getHeight() / 4 * 5, delay3, duration3, viewCards.length-1-i1);
    }

    public void swap(int i1, int i2, int delay, int duration) {
        ViewCard viewCard1 = viewCards[i1];
        ViewCard viewCard2 = viewCards[i2];
        viewCards[i1] = viewCard2;
        viewCards[i2] = viewCard1;

        duration = duration - 20;

        Animation.translate(viewCard1, (int) (dx * (i2 - i1)), 0, delay, duration, viewCards.length-1-i2);
        Animation.translate(viewCard2, (int) (dx * (i1 - i2)), 0, delay, duration, viewCards.length-1-i1);
    }

    public void pickUp1(int i, int delay, int duration) {
        Animation.translate(viewCards[i], 0, viewCards[i].getHeight() / 4, delay, duration , viewCards.length-1-i);
    }

    public void pickDown1(int i, int delay, int duration) {
        Animation.translate(viewCards[i], 0, -viewCards[i].getHeight() / 4, delay, duration, viewCards.length-1-i);
    }

    public void pickUp2(int i, int delay, int duration) {
        Animation.translate(viewCards[i], 0, viewCards[i].getHeight() / 4 * 2, delay, duration , viewCards.length-1-i);
    }

    public void pickDown2(int i, int delay, int duration) {
        Animation.translate(viewCards[i], 0, -viewCards[i].getHeight() / 4 * 2, delay, duration, viewCards.length-1-i);
    }

    public void pickUp3(int i, int delay, int duration) {
        Animation.translate(viewCards[i], 0, viewCards[i].getHeight() / 4 * 3, delay, duration , viewCards.length-1-i);
    }

    public void pickDown3(int i, int delay, int duration) {
        Animation.translate(viewCards[i], 0, -viewCards[i].getHeight() / 4 * 3, delay, duration, viewCards.length-1-i);
    }

    public void pickUp5(int i, int delay, int duration) {
        Animation.translate(viewCards[i], 0, viewCards[i].getHeight() / 4 * 5, delay, duration , viewCards.length-1-i);
    }

    public void pickDown5(int i, int delay, int duration) {
        Animation.translate(viewCards[i], 0, -viewCards[i].getHeight() / 4 * 5, delay, duration, viewCards.length-1-i);
    }
}
