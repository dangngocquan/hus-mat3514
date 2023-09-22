package hw2_21000699_dangngocquan.exercise003.components;

import hw2_21000699_dangngocquan.exercise003.App;
import hw2_21000699_dangngocquan.exercise003.Config;
import hw2_21000699_dangngocquan.exercise003.models.Card;
import hw2_21000699_dangngocquan.exercise003.services.Service;
import hw2_21000699_dangngocquan.exercise003.services.animation.Animation;
import hw2_21000699_dangngocquan.exercise003.services.animation.Location;

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
        widthPerCard = (Config.WIDTH_OF_CARD / 3);
        dx = (Config.WIDTH - widthPerCard - 20) * 1.0 / (cards.length - 1);
        scale = widthPerCard * 1.0 / Config.WIDTH_OF_CARD;
        for (int i = 0; i < viewCards.length; i++) {
            viewCards[i] = new ViewCard(
                    (int) (dx * i + 10), 10,
                    widthPerCard, ((int) (Config.HEIGHT_OF_CARD * scale)) / 4 * 4,
                    cards[i]
            );
            add(viewCards[i]);
        }
        shuffleCards();
    }

    public App getApp() {
        return (App) (Service.getFrame(this));
    }

    public int getLocationX(int i) {
        return (int) (dx * i + 10);
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

    public void pickAndSwapCards(int i1, int i2, int delay, int duration) {
        ViewCard viewCard1 = viewCards[i1];
        ViewCard viewCard2 = viewCards[i2];

        duration = duration - 20;

        Location l11 = new Location(viewCard1.getX(), viewCard1.getY());
        Location l21 = new Location(viewCard2.getX(), viewCard2.getY());
        int delay1 = delay;
        int duration1 = duration / 4;

        Location l12 = new Location(l11.getX(), l11.getY() + viewCard1.getHeight() / 4 * 5);
        Location l22 = new Location(l21.getX(), l21.getY() + viewCard2.getHeight() / 4 * 5);
        int delay2 = delay1 + duration1 + 10;
        int duration2 = duration / 2;

        int delay3 = delay2 + duration2 + 10;
        int duration3 = duration / 4;

        pickUp5(i1, l11, delay1, duration1);
        pickUp5(i2, l21, delay1, duration1);
        swap(i1, l12, i2, l22, delay2, duration2);
        pickDown5(i1, l12, delay3, duration3);
        pickDown5(i2, l22, delay3, duration3);


    }

    public void swap(int i1, Location l1, int i2, Location l2, int delay, int duration) {
        ViewCard viewCard1 = viewCards[i1];
        ViewCard viewCard2 = viewCards[i2];
        viewCards[i1] = viewCard2;
        viewCards[i2] = viewCard1;

//        Location l1 = new Location(viewCard1.getX(), viewCard1.getY());
//        Location l2 = new Location(viewCard2.getX(), viewCard2.getY());

        Animation.translate(viewCard1, l1, (int) (dx * (i2 - i1)), 0, delay,
                duration, viewCards.length-1-i2);
        Animation.translate(viewCard2, l2, (int) (dx * (i1 - i2)), 0, delay, duration, viewCards.length-1-i1);
    }

    public void pickUp1(int i, Location l, int delay, int duration) {
//        Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
        Animation.translate(viewCards[i], l, 0, viewCards[i].getHeight() / 4, delay, duration , viewCards.length-1-i);
    }

    public void pickDown1(int i, Location l, int delay, int duration) {
//        Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
        Animation.translate(viewCards[i], l, 0, -viewCards[i].getHeight() / 4, delay, duration, viewCards.length-1-i);
    }

    public void pickUp2(int i, Location l, int delay, int duration) {
//        Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
        Animation.translate(viewCards[i], l,0, viewCards[i].getHeight() / 4 * 2, delay, duration , viewCards.length-1-i);
    }

    public void pickDown2(int i, Location l, int delay, int duration) {
//        Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
        Animation.translate(viewCards[i], l, 0, -viewCards[i].getHeight() / 4 * 2, delay, duration, viewCards.length-1-i);
    }

    public void pickUp3(int i, Location l, int delay, int duration) {
//        Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
        Animation.translate(viewCards[i], l, 0, viewCards[i].getHeight() / 4 * 3, delay, duration , viewCards.length-1-i);
    }

    public void pickDown3(int i, Location l, int delay, int duration) {
//        Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
        Animation.translate(viewCards[i], l, 0, -viewCards[i].getHeight() / 4 * 3, delay, duration, viewCards.length-1-i);
    }

    public void pickUp5(int i, Location l, int delay, int duration) {
//        Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
        Animation.translate(viewCards[i], l, 0, viewCards[i].getHeight() / 4 * 5, delay, duration , viewCards.length-1-i);
    }

    public void pickDown5(int i, Location l, int delay, int duration) {
//        Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
        Animation.translate(viewCards[i], l, 0, -viewCards[i].getHeight() / 4 * 5, delay, duration, viewCards.length-1-i);
    }

    public void pickUp1All(int i1, int i2, int delay, int duration) {
        for (int i = i1; i <= i2; i++) {
            Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
            pickUp1(i, l, delay, duration);
        }
    }

    public void pickDown1All(int i1, int i2, int delay, int duration) {
        for (int i = i1; i <= i2; i++) {
            Location l = new Location(viewCards[i].getX(), viewCards[i].getY());
            pickDown1(i, l, delay, duration);
        }
    }
}
