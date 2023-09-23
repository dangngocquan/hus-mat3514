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
    public static int y0Card;
    public static int y1Card, y2Card, y3Card, y5Card, y6Card;
    public static int x0Card;
    public static int[] xCards; // xCards[i] is x coordinate of card i in view

    private ViewCard[] viewCards = null;
    private int widthPerCard;
    private int heightPerCard;
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
        heightPerCard = ((int) (Config.HEIGHT_OF_CARD * scale)) / 4 * 4;
        y0Card = 10;
        y1Card = y0Card + heightPerCard / 4;
        y2Card = y0Card + heightPerCard / 4 * 2;
        y3Card = y0Card + heightPerCard / 4 * 3;
        y5Card = y0Card + heightPerCard / 4 * 5;
        y6Card = y0Card + heightPerCard / 4 * 6;
        x0Card = 10;
        xCards = new int[numberCards];
        for (int i = 0; i < viewCards.length; i++) {
            xCards[i] = (int) (dx * i + x0Card);
            viewCards[i] = new ViewCard(
                    xCards[i], y0Card,
                    widthPerCard, heightPerCard,
                    cards[i]
            );
            add(viewCards[i]);
        }
        shuffleCards();
    }

    public App getApp() {
        return (App) (Service.getFrame(this));
    }

//    public int getLocationX(int i) {
//        return (int) (dx * i + 10);
//    }

    public ViewCard[] getViewCards() {
        return viewCards;
    }

    public void updateViewCards() {
        for (int i = 0; i < viewCards.length; i++) {
            viewCards[i].setXY((int) (dx * i + 10), y0Card);
            this.setComponentZOrder(viewCards[i], viewCards.length-1-i);
        }
    }

    public void updateZOrder() {
        for (int i = 0; i < viewCards.length; i++) {
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

        Location l12 = new Location(l11.getX(), l11.getY() + heightPerCard / 4 * 5);
        Location l22 = new Location(l21.getX(), l21.getY() + heightPerCard / 4 * 5);
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

        Animation.translate(viewCard1, l1, xCards[i2] - xCards[i1], 0, delay,
                duration, viewCards.length-1-i2);
        Animation.translate(
                viewCard2, l2,
                xCards[i1] - xCards[i2], 0,
                delay, duration,
                viewCards.length-1-i1
        );
    }

    public void move(int i1, Location l1, int i2, Location l2, int delay, int duration) {
        Animation.translate(
                viewCards[i1], l1,
                l2.getX() - l1.getX(), l2.getY() - l1.getY(),
                delay, duration,
                viewCards.length-1-i2
        );
    }

    public void pickUp1(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l,
                0, heightPerCard / 4,
                delay, duration ,
                viewCards.length-1-i
        );
    }

    public void pickDown1(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l, 0,
                -heightPerCard/4,
                delay, duration,
                viewCards.length-1-i
        );
    }

    public void pickUp2(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l,
                0, heightPerCard / 4 * 2,
                delay, duration ,
                viewCards.length-1-i
        );
    }

    public void pickDown2(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l,
                0, -heightPerCard / 4 * 2,
                delay, duration,
                viewCards.length-1-i
        );
    }

    public void pickUp3(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l, 0,
                heightPerCard / 4 * 3,
                delay, duration ,
                viewCards.length-1-i
        );
    }

    public void pickDown3(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l,
                0, -heightPerCard / 4 * 3,
                delay, duration,
                viewCards.length-1-i
        );
    }

    public void pickUp5(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l,
                0, heightPerCard / 4 * 5,
                delay, duration ,
                viewCards.length-1-i
        );
    }

    public void pickDown5(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l,
                0, -heightPerCard / 4 * 5,
                delay, duration,
                viewCards.length-1-i
        );
    }

    public void pickDown6(int i, Location l, int delay, int duration) {
        Animation.translate(
                viewCards[i], l,
                0, -heightPerCard / 4 * 6,
                delay, duration,
                viewCards.length-1-i
        );
    }

    public void pickUp1All(int initialY, int i1, int i2, int delay, int duration) {
        Location[] l = new Location[i2-i1+1];
        for (int i = i1; i <= i2; i++) {
            l[i-i1] = new Location(xCards[i], initialY);
        }
        for (int i = i1; i <= i2; i++) {
            pickUp1(i, l[i-i1], delay, duration);
        }
    }

    public void pickDown1All(int initialY, int i1, int i2, int delay, int duration) {
        Location[] l = new Location[i2-i1+1];
        for (int i = i1; i <= i2; i++) {
            l[i-i1] = new Location(xCards[i], initialY);
        }
        for (int i = i1; i <= i2; i++) {
            pickDown1(i, l[i-i1], delay, duration);
        }
    }

    public void pickDown6All(int initialY, int i1, int i2, int delay, int duration) {
        Location[] l = new Location[i2-i1+1];
        for (int i = i1; i <= i2; i++) {
            l[i-i1] = new Location(xCards[i], initialY);
        }
        for (int i = i1; i <= i2; i++) {
            pickDown6(i, l[i-i1], delay, duration);
        }
    }
}
